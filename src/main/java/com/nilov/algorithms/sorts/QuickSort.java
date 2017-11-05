package com.nilov.algorithms.sorts;

public class QuickSort {

    private QuickSort() {}

    public static int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int start, int end) {
        if(start < end) {
            int q = partition(arr, start, end);
            sort(arr, start, q - 1);
            sort(arr, q + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for(int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, end);
        return i;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int e = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = e;
    }
}
