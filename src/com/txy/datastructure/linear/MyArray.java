package com.txy.datastructure.linear;

public class MyArray<T> {
     private T[] array;

     public MyArray(){
         this.array = (T[])new Object[0];
     }

     public T getData(int index) {
         if(index < 0 || index > this.array.length){
             throw new RuntimeException("Out of the array's length...");
         }
         return this.array[index];
     }

     public int getArrayLength(){
         return this.array.length;
     }

     public void addData(T data){
         T[] newArray =  (T[])new Object[this.array.length + 1];
         for (int i = 0; i < this.array.length; i++) {
             newArray[i] = this.array[i];
         }
         newArray[newArray.length - 1] = data;
         this.array = newArray;
     }

     public void deleteData(int index) {
         if(index < 0 || index > this.array.length){
             throw new RuntimeException("Out of the array's length...");
         }
         T[] newArray =  (T[])new Object[this.array.length - 1];
         for (int i = 0, j = 0; i < newArray.length; i++, j++) {
             if(j == index){
                j = j + 1;
             }
             newArray[i] = this.array[j];
         }
         this.array = newArray;
     }

     public int searchData(T data) {
         int position = -1;
         for(int i = 0; i < this.array.length; i++){
             if(data.equals(this.array[i])){
                 position = i;
                 break;
             }
         }
         return position;
     }

     public void setData(int index, T element) {
         if(index < 0 || index > this.array.length){
             throw new RuntimeException("Out of the array's length...");
         }
         this.array[index] = element;
     }
}
