package com.nilov.algorithms.sorts;

public class InsertionSort {

    private InsertionSort() { }

    public static Integer[] sort(Integer[] arr) {
        int length = arr.length;
        int temp, j;

        for(int i = 1; i < length; i++) {
            temp = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        return arr;
    }

    public static Integer[] reverse(Integer[] arr) {
        int length = arr.length;
        int temp, j;

        for(int i = length - 2; i >= 0; i--) {
            temp = arr[i];
            j = i + 1;

            while (j <= length && arr[j] < temp) {
                arr[j - 1] = arr[j];
                j++;
            }
            arr[j - 1] = temp;
        }

        return arr;
    }

}
