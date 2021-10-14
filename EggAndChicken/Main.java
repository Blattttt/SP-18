package com.company;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String winner;
        EggChicken chicken = new EggChicken("Яйцо", 1);
        EggChicken egg = new EggChicken("Курица", 1);
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
            }}
        chicken.join();
        egg.join();
        System.out.println(winner);
    }}
