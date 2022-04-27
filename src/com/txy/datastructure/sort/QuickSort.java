package com.txy.datastructure.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] data = new int[]{2,1,7,5,9,0};
        quickSort(data, 0, data.length - 1);
        System.out.print(Arrays.toString(data));
    }

    public static void quickSort(int[] data, int begin, int end){
        if(begin >= end){
            return;
        }
        int standard = data[begin];
        int low = begin;
        int high = end;
        while(low < high){
            while(low < high && standard <= data[high]){
                high--;
            }
            data[low] = data[high];
            while(low < high && standard > data[low]){
                low++;
            }
            data[high] = data[low];
        }
        data[low] = standard;
        quickSort(data, begin, low);
        quickSort(data, low + 1, end);
    }
}
