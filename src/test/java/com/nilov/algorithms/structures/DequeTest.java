package com.nilov.algorithms.structures;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.*;

public class DequeTest {
    @Test
    public void testAddFirst() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addFirst(6);
        System.out.println(deque.popLast());
        System.out.println(deque.popLast());
        System.out.println(deque.popLast());
        System.out.println(deque.popLast());
        System.out.println(deque.popFirst());
        System.out.println(deque.popFirst());
        System.out.println(deque.popFirst());
    }
}