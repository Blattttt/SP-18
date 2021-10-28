package com.company;
public class Main {
    public static void main(String[] args){
        CopyingProcess copy = new CopyingProcess(
                "C:\\Users\\ASUS\\IdeaProjects\\fileCopy2\\1.txt", //Путь к 1-му файлу
                "C:\\Users\\ASUS\\IdeaProjects\\fileCopy2\\2.txt", //Путь к 2-му файлу (в него копируется первый)
                "C:\\Users\\ASUS\\IdeaProjects\\fileCopy2\\3.txt", //Путь к 3-му файлу
                "C:\\Users\\ASUS\\IdeaProjects\\fileCopy2\\4.txt");//Путь к 4-му файлу (в него копируется третий)
    }}