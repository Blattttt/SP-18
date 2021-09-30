package com.company;

public class Multiplication {
    private int num1;
    private int num2;
    Multiplication(int a, int b){
        this.num1 = a;
        this.num2 = b;
    }
    public int Multi(){
        float num3 = (float)num1/(1/(float)num2);
        return Math.round(num3);
    }
}
