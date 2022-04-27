package com.txy.datastructure.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,7,5,4,2,3,9};
        shellSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr){
        for(int d = arr.length/2; d > 0; d = d/2){
            for(int i = d; i < arr.length; i++){
                for(int j = i - d; j > 0; j = j - d){
                    if(arr[j] > arr[j + d]){
                        int temp = arr[j + d];
                        arr[j + d] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
