package com.nilov.algorithms.sorts;


/**
 * Алгортим работает с числами в диапазоне [0 .. k-1]
 */
public class CountingSort {

    private CountingSort() {}

    public static Integer[] sort(Integer[] arr) {
        int maxValue = findMaxValue(arr);
        int[] counts = new int[maxValue + 1];

        for(int e: arr)
            counts[e]++;

        populateCounts(arr, counts);

        return arr;
    }

    private static int findMaxValue(Integer[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i: arr) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }

    private static void populateCounts(Integer[] unsorted, int[] counts) {
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int e = counts[i];
            while (e > 0) {
                unsorted[index++] = i;
                e--;
            }
        }
    }
}
