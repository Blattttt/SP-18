package com.company;

public class Main {
    public static void main(String[] args) {

        //Создание потока и присваивание приоритета
        ThreadLoad turtle = new ThreadLoad("Музыка", 1);
        ThreadLoad rabbit = new ThreadLoad("Картинка", 2);
    }}

