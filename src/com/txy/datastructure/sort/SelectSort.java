package com.txy.datastructure.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 0, 3, 4, 1, 7};
        selectSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int j;
            int min = arr[i];
            int index = i;
            for(j = i; j < arr.length; j++){
               if(arr[j] < min){
                    min = arr[j];
                    index = j;
               }
            }
            if(i != index){
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
