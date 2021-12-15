package com.company;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 8080);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            String s = "Привет";
            int response = 1;
            byte[] buffer;
            buffer = s.getBytes();
            outputStream.write(buffer);
            System.out.println("отправлено серверу: " + response);

            while ((response = inputStream.read()) != -1) {
                Scanner scanner = new Scanner("Введите сообщение: ");
                s = scanner.nextLine();
                scanner.close();
                System.out.println("прислал сервер: " + response);
                if (s.equals("Стоп")) {
                    break;
                }
                buffer = s.getBytes();
                outputStream.write(buffer);
                buffer.toString()
                System.out.println("отправлено серверу: " + response);
                outputStream.flush();
            }} catch (IOException e) {
            e.printStackTrace();
        }}}