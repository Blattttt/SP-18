package com.company;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        CopyingProcess first = new CopyingProcess(
                "D:\\fileCopy\\src\\com\\company\\1.txt", //Путь к 1-му файлу
                "D:\\2.txt",                              //Путь к 2-му файлу (в него копируется первый)
                "D:\\fileCopy\\src\\com\\company\\3.txt", //Путь к 3-му файлу
                "D:\\4.txt");                             //Путь к 4-му файлу (в него копируется третий)
    }
}
