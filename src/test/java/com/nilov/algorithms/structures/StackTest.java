package com.nilov.algorithms.structures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

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
    public void testPopEmptyStackException() throws Exception {
        thrown.expect(EmptyStackException.class);
        Stack stack = new Stack();
        stack.pop();
    }

    @Test
    public void testPeekEmptyStackException() throws Exception {
        thrown.expect(EmptyStackException.class);
        Stack stack = new Stack();
        stack.peek();
    }

    @Test
    public void testPushAndPop() throws Exception {
        Stack stack = new Stack();
        int element;
        for (int aData : data) stack.push(aData);

        assertTrue(!stack.isEmpty());

        int index = data.length - 1;

        while (!stack.isEmpty()) {
            element = stack.pop();
            assertEquals(data[index], element);
            index--;
        }

        thrown.expect(EmptyStackException.class);
        element = stack.pop();

        assertTrue(stack.isEmpty());
    }
}