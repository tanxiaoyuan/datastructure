package com.txy.datastructure.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{250, 345, 67, 12, 1, 0, 8};
        radixSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int length = (max + "").length();
        int[][] temp = new int[10][arr.length];
        for(int j = 0, n = 1; j <= length; j++, n = n * 10){
            int[] counts = new int[10];
            int index = 0;
            for(int k = 0; k < arr.length; k++){
                int ys = arr[k] / n % 10;
                temp[ys][counts[ys]] = arr[k];
                counts[ys] ++;
            }
            for(int l = 0; l < counts.length; l++){
                if(counts[l] != 0){
                    for(int m = 0; m < counts[l]; m++){
                        arr[index] = temp[l][m];
                        index++;
                    }
                }
            }
        }
    }
}
