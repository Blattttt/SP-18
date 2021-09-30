package com.company;

import static org.junit.Assert.*;

public class MultiplicationTest {

    @org.junit.Test
    public void Multi() {
        Multiplication multiplication = new Multiplication(5, 5);
        int actual = multiplication.Multi();
        int expected = 25;
        assertEquals(expected, actual);
    }
}