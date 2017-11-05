package com.nilov.algorithms.sorts;

public class BubbleSort {

    private BubbleSort() {}

    public static int[] sort(int[] arr) {
        int length = arr.length;
        boolean swapped = true;

        while(swapped) {
            swapped = false;
            for (int i = 1; i < length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swapped = true;
                    swap(arr, i - 1, i);
                }
            }
            length--;
        }
        return arr;
    }

    public static int[] reverse(int[] arr) {
        int startElement = arr.length - 1;
        int endElement = 0;
        boolean swapped = true;

        while(swapped) {
            swapped = false;
            for (int i = startElement; i > endElement; i--) {
                if (arr[i - 1] < arr[i]) {
                    swapped = true;
                    swap(arr, i - 1, i);
                }
            }
            endElement++;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int e = arr[j];
        arr[j] = arr[i];
        arr[i] = e;
    }
}
