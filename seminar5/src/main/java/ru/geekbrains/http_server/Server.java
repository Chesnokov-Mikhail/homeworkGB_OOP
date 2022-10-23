package ru.geekbrains.http_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            // путь до базовой директории сервера
            String wwwDirectory = new File(".\\www\\").getAbsolutePath();

            for(;;) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(), StandardCharsets.UTF_8));

                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream());
                // для формирования ответа на запрос
                Response response = new Response(writer, wwwDirectory);

                while (!reader.ready()) ;

                while (reader.ready()) {
                   String[] request = reader.readLine().split(" ");
                    if (request[0].trim().equals("GET")) {
                        // формируем ответ по запрошенной странице
                        response.getContext(request[1].trim());
                    }
                }
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
