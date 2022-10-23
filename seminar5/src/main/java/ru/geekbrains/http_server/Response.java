package ru.geekbrains.http_server;

import java.io.*;

public class Response {
    private PrintWriter writer;

    private String baseDir;

    public Response(PrintWriter writer, String baseDir) {
        this.writer = writer;
        this.baseDir = baseDir;
    }

    // считывает и выдает найденную страницу
    public void getContext(String page) {
        page = this.baseDir + page;
        try {
            File file = new File(new File(page).getAbsolutePath());
            if (file.exists() && file.isFile()) {
                BufferedReader bufReader = new BufferedReader(new FileReader(file));
                String str = null;
                try {
                    this.writer.println("HTTP/1.1 200 OK");
                    this.writer.println("Content-Type: text/html; charset=utf-8");
                    this.writer.println();
                    while ((str = bufReader.readLine()) != null) {
                        this.writer.println(str);
                    }
                    this.writer.flush();
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                    getContext500();
                } finally {
                    bufReader.close();
                }
            } else {
                getContext404();
            }
        } catch (IOException e) {
            getContext500();
            System.out.println(e.getLocalizedMessage());
        }
    }

    // Если страница не найдена
    public void getContext404() {
        writer.println("HTTP/1.1 404 Not Found");
        writer.println("Content-Type: text/html; charset=utf-8");
        writer.println();
        writer.flush();
    }

    // Если произошла внутренняя ошибка сервера
    public void getContext500() {
        writer.println("HTTP/1.1 500 Internal Server Error");
        writer.println("Content-Type: text/html; charset=utf-8");
        writer.println();
        writer.flush();
    }
}
