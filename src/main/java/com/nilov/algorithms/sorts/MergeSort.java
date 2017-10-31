package com.nilov.algorithms.sorts;

public class MergeSort {

    private MergeSort() {}

    public static Integer[] sort(Integer[] arr) {
        return mergeSort(arr, 0, arr.length);
    }

    public static Integer[] reverse(Integer[] arr) {
        return arr;
    }

    private static Integer[] mergeSort(Integer[] arr, int start, int length) {
        if (length > 2) {
            int leftLength = (int) Math.floor(length / 2);
            int rightLength = length - leftLength;
            arr = mergeSort(arr, start, leftLength);
            arr = mergeSort(arr, start + leftLength, rightLength);
            arr = merge(arr, start, leftLength, start + leftLength, rightLength);
        } else if (length == 2) {
            Integer e = arr[start + 1];
            if (arr[start + 1] < arr[start]) {
                arr[start + 1] = arr[start];
                arr[start] = e;
            }
        }
        return arr;
    }

    private static Integer[] merge(Integer[] arr, int leftStart, int leftLength, int rightStart, int rightLength) {
        Integer[] L = new Integer[leftLength];
        Integer[] R = new Integer[rightLength];

        System.arraycopy(arr, leftStart, L, 0, leftLength);
        System.arraycopy(arr, rightStart, R, 0, rightLength);

        int i = 0, j = 0;
        int k = leftStart;

        while (i < leftLength || j < rightLength) {
            Integer left = null;
            Integer right = null;
            if (i < leftLength)
                left = L[i];
            if (j < rightLength)
                right = R[j];

            if (left != null && right == null) {
                arr[k++] = left;
                i++;
            } else if (left == null && right != null) {
                arr[k++] = right;
                j++;
            } else if (left <= right) {
                arr[k++] = left;
                i++;
            } else {
                arr[k++] = right;
                j++;
            }
        }
        return arr;
    }
}
