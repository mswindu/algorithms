package com.nilov.algorithms.data_structures;

import org.junit.Test;

import java.util.Random;

public class StackTest {

    private static final Random RANDOM = new Random();
    private static final int SIZE = 10000;

    private static int[] data = null;

    static {
        data = new int[SIZE];
        int i = 0;
        while (i < data.length) {
            data[i++] = RANDOM.nextInt(data.length * 10);
        }
    }

    @Test
    public void testStack() throws Exception {
        Stack stack = new Stack();

        for (int aData : data) {
            stack.push(aData);
        }
    }
}