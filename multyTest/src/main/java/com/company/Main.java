package com.company;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        try{
            File File_Multi = new File("D:\\", "1.txt");
            BufferedReader Reader = new BufferedReader(new FileReader(File_Multi));
            String s = Reader.readLine();
            StringScan Scanner = new StringScan(s);
            int[] mas_num = Scanner.Reg();
            Multiplication Muli_Nums = new Multiplication(mas_num[0], mas_num[1]);
            int num = Muli_Nums.Multi();
            System.out.println(num);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }}


    public static class StringScan {
        private String str;
        StringScan(String s){
            this.str = s;
        }
        public int[] Reg() {
            Pattern p = Pattern.compile("\\*");
            Matcher m = p.matcher(str);
            int sm = 0;
            while (m.find()) {
                sm = m.start();
            }
            String str_num1 = str.substring(0, sm);
            String str_num2 = str.substring(sm + 1);
            int num1 = Integer.parseInt(str_num1);
            int num2 = Integer.parseInt(str_num2);
            int[] mas = new int[2];
            mas[0] = num1;
            mas[1] = num2;
            return mas;

        }}}