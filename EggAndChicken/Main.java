package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Создание потока и присваивание приоритета
        String winner;
        EggChiken chicken = new EggChiken("Яйцо", 1);
        EggChiken egg = new EggChiken("Курица", 1);
        chicken.start();
        egg.start();

        while (true){
            if (!chicken.isAlive() && egg.isAlive()){

                winner = "выйграла Курица";
                break;
            }
            if ((chicken.isAlive()) && (!egg.isAlive())){
                winner = "выйграло Яйцо";
                break;
            }
        }
        chicken.join();
        egg.join();
        System.out.println(winner);
    }
}
