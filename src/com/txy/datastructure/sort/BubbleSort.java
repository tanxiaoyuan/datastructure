package com.txy.datastructure.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 0, 3, 4, 1, 7};
        bubbleSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] data){
        for(int i = 0; i < data.length - 1; i++){
            for(int j = 0; j < data.length - 1 - i; j++){
                if(data[j] > data[j + 1]){
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}
