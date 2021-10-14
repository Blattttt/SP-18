package com.company;

class EggChiken extends Thread {
    String nameThread;
    int i;
    public EggChiken(String name, int priority) {
        Thread thread = new Thread(this, name);
        this.nameThread = name;
    }


    @Override
    public void run(){
        for (i = 1; i <= 6; i++){
            try{
                Thread.sleep(300);
                System.out.println(nameThread);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
