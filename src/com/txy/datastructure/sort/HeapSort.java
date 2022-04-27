package com.txy.datastructure.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 0, 3, 4, 1, 7};
        heapSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr){
        for(int i = (arr.length - 1) /2; i >= 0; i--){
            maxHeap(arr, arr.length, i);
        }
        for(int i = arr.length - 1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }

    private static void maxHeap(int[] arr, int size, int index){
        int leftNodeIndex = index * 2 + 1;
        int rightNodeIndex = index * 2 + 2;
        int max = index;
        if(leftNodeIndex < size && arr[leftNodeIndex] > arr[max]){
            max = leftNodeIndex;
        }
        if(rightNodeIndex < size && arr[rightNodeIndex] > arr[max]){
            max = rightNodeIndex;
        }
        if(max != index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            maxHeap(arr, size, max);
        }
    }
}
