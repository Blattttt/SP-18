package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{final Process p = Runtime.getRuntime().exec( "2.bat" );
        final int retCode = p.waitFor();} catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }}}
