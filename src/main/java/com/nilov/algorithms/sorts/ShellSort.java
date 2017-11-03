package com.nilov.algorithms.sorts;

public class ShellSort {

    public ShellSort() {}

    public static Integer[] sort(Integer[] arr) {
        int length = arr.length;
        int j;
        for(int k = length / 2; k > 0; k /= 2) {
            for(int i = k; i < length; i++) {
                Integer e = arr[i];
                for(j = i; i >= k; j -= k) {
                    if(e < arr[j - k])
                        arr[j] = arr[j-k];
                    else
                        break;
                }
                arr[j] = e;
            }
        }
        return arr;
    }
}
