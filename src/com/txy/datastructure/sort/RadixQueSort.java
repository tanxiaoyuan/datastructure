package com.txy.datastructure.sort;

import com.txy.datastructure.linear.MyQueue;

import java.util.Arrays;

public class RadixQueSort {
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
        MyQueue<Integer>[] temp = new MyQueue[10];
        for (int i = 0; i < temp.length; i++){
            temp[i] = new MyQueue<>();
        }
        for(int j = 0, n = 1; j <= length; j++, n = n * 10){
            int index = 0;
            for(int k = 0; k < arr.length; k++){
                int ys = arr[k] / n % 10;
                temp[ys].add(arr[k]);
            }
            for(int l = 0; l < temp.length; l++){
                while (temp[l].size() > 0){
                    arr[index] = temp[l].poll();
                    index++;
                }
            }
        }
    }
}
