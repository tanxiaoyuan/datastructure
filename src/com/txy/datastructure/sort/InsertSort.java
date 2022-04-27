package com.txy.datastructure.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,5,4,0,1,12,7};
        insertSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i - 1]){
                int temp = arr[i];
                int j;
                for(j = i - 1; j >= 0  && arr[j] > temp; j--){
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}
