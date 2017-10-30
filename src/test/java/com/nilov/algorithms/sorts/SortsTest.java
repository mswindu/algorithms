package com.nilov.algorithms.sorts;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class SortsTest {
    private static final Random RANDOM = new Random();
    private static final int SIZE = 10;

    private static Integer[] unsorted = null;
    private static Integer[] sorted = null;

    static {
        unsorted = new Integer[SIZE];
        int i = 0;
        while (i < unsorted.length) {
            int j = RANDOM.nextInt(unsorted.length * 10);
            unsorted[i++] = j;
        }

        sorted = new Integer[SIZE];
        for (i = 0; i < sorted.length; i++)
            sorted[i] = i;
    }

    @Test
    public void sort() throws Exception {
        Integer[] result = InsertionSort.sort(unsorted.clone());
        assertTrue("Insertion sort unsorted error. result = " + print(result), check(result));

        //System.out.println(print(unsorted.clone()));
        //System.out.println(print(result));

        result = InsertionSort.sort(sorted.clone());
        assertTrue("Insertion sort sorted error. result = " + print(result), check(result));
    }

    @Test
    public void reverse() throws Exception {
        Integer[] result = InsertionSort.reverse(unsorted.clone());
        assertTrue("Insertion sort unsorted error. result = " + print(result), checkReverse(result));

        result = InsertionSort.reverse(sorted.clone());
        assertTrue("Insertion sort sorted error. result = " + print(result), checkReverse(result));
    }

    private static boolean check(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i])
                return false;
        }
        return true;
    }

    private static boolean checkReverse(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i])
                return false;
        }
        return true;
    }

    private static String print(Integer[] array) {
        return print(array, array.length);
    }

    private static String print(Integer[] array, int length) {
        final Integer[] clone = array.clone();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int e = clone[i];
            builder.append(e).append(" ");
        }
        return builder.toString();
    }

}