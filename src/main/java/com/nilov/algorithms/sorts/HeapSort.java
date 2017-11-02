package com.nilov.algorithms.sorts;

public class HeapSort {

    private static int heapSize;

    private HeapSort() {}

    public static Integer[] sort(Integer[] arr) {
        buildMaxHeap(arr);
        while (heapSize > 1) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            maxHeapify(arr, 0);
        }
        return arr;
    }

    private static void buildMaxHeap(Integer[] arr) {
        heapSize = arr.length;

        for(int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    // Метод для поддержки свойства невозрастающей пирамиды
    private static void maxHeapify(Integer[] arr, int i) {
        int largest;
        int l = left(i);
        int r = right(i);

        if (l < heapSize && arr[i] < arr[l]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < heapSize && arr[largest] < arr[r]) {
            largest = r;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest);
        }
    }

    private static int left(int i) {
        return i << 1;
    }

    private static int right(int i) {
        return (i << 1) + 1;
    }

    private static void swap(Integer[] arr, int index1, int index2) {
        Integer e = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = e;
    }
}
