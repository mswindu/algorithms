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

    private static Integer[] data = null;

    static {
        data = new Integer[SIZE];
        int i = 0;
        while (i < data.length) {
            data[i++] = RANDOM.nextInt(data.length * 10);
        }
    }

    @Test
    public void testPopEmptyStackException() throws Exception {
        thrown.expect(EmptyStackException.class);
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }

    @Test
    public void testPeekEmptyStackException() throws Exception {
        thrown.expect(EmptyStackException.class);
        Stack<Integer> stack = new Stack<>();
        stack.peek();
    }

    @Test
    public void testPushAndPop() throws Exception {
        Stack<Integer> stack = new Stack();
        Object element;
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

    @Test
    public void testSearchExistsElement() throws Exception{
        Stack<Integer> stack = new Stack<>();
        Integer currentObject = null;
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);

        Object searchObject = new Integer(5);

        int length = stack.search(searchObject);

        for(int i = 0; i < length; i++) {
            currentObject = stack.pop();
        }

        assertEquals(searchObject, currentObject);
    }

    @Test
    public void testSearchNotExistsElement() throws Exception{
        Stack<Integer> stack = new Stack<>();
        Integer currentObject = null;
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);

        Object searchObject = new Integer(50);

        int length = stack.search(searchObject);

        assertEquals(length, -1);
    }
}