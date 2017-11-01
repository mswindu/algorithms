package com.nilov.algorithms.sorts;

public class BubbleSort {

    private BubbleSort() {}

    public static Integer[] sort(Integer[] arr) {
        int length = arr.length;
        boolean swapped = true;

        while(swapped) {
            swapped = false;
            for (int i = 1; i < length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swapped = true;
                    arr = swap(arr, i - 1, i);
                }
            }
            length--;
        }
        return arr;
    }

    public static Integer[] reverse(Integer[] arr) {
        int startElement = arr.length - 1;
        int endElement = 0;
        boolean swapped = true;

        while(swapped) {
            swapped = false;
            for (int i = startElement; i > endElement; i--) {
                if (arr[i - 1] < arr[i]) {
                    swapped = true;
                    arr = swap(arr, i - 1, i);
                }
            }
            endElement++;
        }
        return arr;
    }

    private static Integer[] swap(Integer[] arr, int i, int j) {
        Integer e = arr[j];
        arr[j] = arr[i];
        arr[i] = e;
        return arr;
    }
}
