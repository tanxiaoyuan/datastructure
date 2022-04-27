package com.txy.datastructure.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,10,2,7,3,-1};
        mergeSort(arr, 0,arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int middle = (start + end) / 2;
            mergeSort(arr, 0, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end){
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = middle + 1;
        int index = 0;
        while(i <= middle && j <= end){
            if (arr[i] <= arr[j]){
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        while(i <= middle){
            temp[index] = arr[i];
            i++;
            index++;
        }
        while(j <= end){
            temp[index] = arr[j];
            j++;
            index++;
        }
        for(int k = 0; k < temp.length; k++){
            arr[k + start] = temp[k];
        }
    }
}
