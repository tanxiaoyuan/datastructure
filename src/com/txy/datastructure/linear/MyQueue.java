package com.txy.datastructure.linear;

public class MyQueue<T> {

    private T[] elements;

    public MyQueue(){
        this.elements =  (T[]) new Object[0];
    }

    public int size(){
        return this.elements.length;
    }

    public void add(T data){
        T[] newElements =  (T[])new Object[this.elements.length + 1];
        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }
        newElements[newElements.length - 1] = data;
        this.elements = newElements;
    }

    public T poll(){
        if(this.elements.length == 0){
            throw new RuntimeException("The queue is empty.");
        }
        T data = this.elements[0];
        T[] newElements =  (T[])new Object[this.elements.length - 1];
        for(int i = 1; i < this.elements.length; i++){
            newElements[i - 1] = this.elements[i];
        }
        this.elements = newElements;
        return data;
    }

}
