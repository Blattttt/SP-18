package com.company;

class AnimalThread implements Runnable {
    Thread animal;

    public AnimalThread(String name, int priority) {
        animal = new Thread(this, name);
        //Создание потока животные
        System.out.println("Поток " + name + " запущен");
        //Вывод названия потока
        animal.setPriority(priority);
        animal.start();
        //Присваивание приоритета и запуск потока
        int Priority = animal.getPriority();
        System.out.println(Priority);
        //Вывод приоритета
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println(animal.getName() + ": " + i + "/10 м");
            //Условное расстояние забега
            try {
                Thread.sleep(1000);
                //Условная скорость животных
            } catch (InterruptedException e) {
                System.out.println("Поток " + animal.getName() + " прерван");
            }}
        System.out.println("Поток " + animal.getName() +" завершен");
    }}
