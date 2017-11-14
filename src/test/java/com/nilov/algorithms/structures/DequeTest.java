package com.nilov.algorithms.structures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DequeTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private static final int SIZE = 10000;

    private static Integer[] data = null;

    static {
        data = new Integer[SIZE];
        int i = 0;
        while (i < data.length) {
            data[i++] = i;
        }
    }

    @Test
    public void testDequeIsEmpty() throws Exception {
        Deque<Integer> deque = new Deque<>();
        assertEquals(deque.isEmpty(), true);
    }

    @Test
    public void testDequeIsNotEmpty() throws Exception {
        Deque<Integer> deque = new Deque<>();
        for (Integer aData : data) {
            deque.addLast(aData);
        }
        assertEquals(deque.isEmpty(), false);
    }

    @Test
    public void testAddFirstEmptyItem() throws Exception {
        thrown.expect(NullPointerException.class);
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test
    public void testAddLastEmptyItem() throws Exception {
        thrown.expect(NullPointerException.class);
        Deque<Integer> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test
    public void testAddFirstPopLast() throws Exception {
        int i = 0;
        Deque<Integer> deque = new Deque<>();
        for (Integer aData : data) {
            deque.addFirst(aData);
        }

        while (!deque.isEmpty()) {
            assertEquals(deque.popLast(), data[i++]);
        }

        assertEquals(deque.popLast(), null);
    }

    @Test
    public void testAddLastPopFirst() throws Exception {
        int i = 0;
        Deque<Integer> deque = new Deque<>();
        for (Integer aData : data) {
            deque.addLast(aData);
        }

        while (!deque.isEmpty()) {
            assertEquals(deque.popFirst(), data[i++]);
        }

        assertEquals(deque.popFirst(), null);
    }

    @Test
    public void testAddFirstPopFirst() throws Exception {
        int i = data.length;
        Deque<Integer> deque = new Deque<>();
        for (Integer aData : data) {
            deque.addFirst(aData);
        }

        while (!deque.isEmpty()) {
            assertEquals(deque.popFirst(), data[--i]);
        }

        assertEquals(deque.popFirst(), null);
    }

    @Test
    public void testAddLastPopLast() throws Exception {
        int i = data.length;
        Deque<Integer> deque = new Deque<>();
        for (Integer aData : data) {
            deque.addLast(aData);
        }

        while (!deque.isEmpty()) {
            assertEquals(deque.popLast(), data[--i]);
        }

        assertEquals(deque.popLast(), null);
    }
}