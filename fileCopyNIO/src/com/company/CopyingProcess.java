package com.company;
import java.io.*;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

class CopyingProcess implements Runnable {
    Thread thread;
    String path1;
    String path1to2;                            //Описание переменных
    String path3;
    String path3to4;

    public CopyingProcess(String pathname1, String pathname2, String pathname3, String pathname4) {
        thread = new Thread(this, pathname1);
        path1 = pathname1;
        path1to2 = pathname2;
        path3 = pathname3;                      //Присваивание переменным пути файлов
        path3to4 = pathname4;
        thread.start();
    }

    @Override
    public void run() {
        try {
            copyFile(path1, path1to2);
            copyFile(path3, path3to4);          //Описание метода run, запуск метода копирования
        } catch (IOException e) {
            e.printStackTrace();
        }}

    private static void copyFile(String source, String dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {                                   //Описание метода копирования
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }finally{
            Objects.requireNonNull(sourceChannel).close();
            Objects.requireNonNull(destChannel).close();
        }}
}