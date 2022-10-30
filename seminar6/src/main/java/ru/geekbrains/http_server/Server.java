package ru.geekbrains.http_server;

import ru.geekbrains.http_server.logger.Logger;
import ru.geekbrains.http_server.logger.LoggerFactory;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static ru.geekbrains.http_server.IoProcessors.PROCESSORS;

public class Server {

    private static final String WWW = "./www";

    private static final int port = 8080;

    private static final String inetAddress = "http://localhost:"+ Integer.toString(port) +"/";

    private static final Logger logger = LoggerFactory.create();

    // возвращает путь к корневой папке сервера
    public static Path getWWW() {
        return Path.of(WWW);
    }
    // возвращает адрес сервера
    public static String getInetAddress() {
        return inetAddress;
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            for (; ; ) {
                try (Socket socket = serverSocket.accept()) {
                    handleRequest(socket);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void handleRequest(Socket socket) throws IOException {
        logger.log("Client connected");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));

        PrintWriter writer = new PrintWriter(
                socket.getOutputStream());

        while (!reader.ready()) ;

        String[] items = {"", "", ""};
        if (reader.ready()) {
            String line = reader.readLine();
            System.out.println(line);
            items = line.split(" ");
        }

        while (reader.ready()) {
            logger.log(reader.readLine());
        }

        Path filePath = Path.of(WWW, items[1]);

        for (Map.Entry<Predicate<Path>, BiConsumer<Path, PrintWriter>> entry : PROCESSORS.entrySet()) {
            Predicate<Path> pred = entry.getKey();
            BiConsumer<Path, PrintWriter> processor = entry.getValue();
            if (pred.test(filePath)) {
                processor.accept(filePath, writer);
                break;
            }
        }

        writer.flush();
    }
}
