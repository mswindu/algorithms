package com.nilov.algorithms.sorts;

public class MergeSort {

    private MergeSort() {}

    public static int[] sort(int[] arr) {
        mergeSort(arr, 0, arr.length);
        return arr;
    }

    private static void mergeSort(int[] arr, int start, int length) {
        if (length > 2) {
            int leftLength = (int) Math.floor(length / 2);
            int rightLength = length - leftLength;
            mergeSort(arr, start, leftLength);
            mergeSort(arr, start + leftLength, rightLength);
            merge(arr, start, leftLength, start + leftLength, rightLength);
        } else if (length == 2) {
            int e = arr[start + 1];
            if (arr[start + 1] < arr[start]) {
                arr[start + 1] = arr[start];
                arr[start] = e;
            }
        }
    }

    private static void merge(int[] arr, int leftStart, int leftLength, int rightStart, int rightLength) {
        int[] L = new int[leftLength];
        int[] R = new int[rightLength];

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
    }
}
