package com.nilov.algorithms.sorts;

public class ShellSort {

    public ShellSort() {}

    public static int[] sort(int[] arr) {
        int length = arr.length;
        int j;
        for(int gap = length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < length; i++) {
                int e = arr[i];
                for(j = i; j >= gap; j -= gap) {
                    if(e < arr[j - gap])
                        arr[j] = arr[j-gap];
                    else
                        break;
                }
                arr[j] = e;
            }
        }
        return arr;
    }
}
