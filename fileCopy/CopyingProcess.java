package com.company;

import java.io.*;
import java.io.IOException;

class CopyingProcess implements Runnable {
    Thread thread;
    String path1;
    String path1to2;
    String path3;
    String path3to4;

    public CopyingProcess(String pathname1, String pathname2, String pathname3, String pathname4) {
        thread = new Thread(this, pathname1);
        path1 = pathname1;
        path1to2 = pathname2;
        path3 = pathname3;
        path3to4 = pathname4;
        thread.start();
    }

    @Override
    public void run() {
        try {
            copyFileUsingStream(path1, path1to2);
            copyFileUsingStream2(path3, path3to4);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileUsingStream(String source, String dest) throws IOException {
        try (InputStream is = new FileInputStream(String.valueOf(source)); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }}}
            //Методы копирования
    private static void copyFileUsingStream2(String source, String dest) throws IOException {
        try (InputStream is = new FileInputStream(String.valueOf(source)); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }}}
}