package com.txy.datastructure.linear;

public class MyStack<T> {
    T[] elements;

    public MyStack(){
        this.elements = (T[])new Object[0];
    }

    public boolean isEmpty(){
        return this.elements.length == 0;
    }

    public void push(T data){
        T[] newArray =  (T[])new Object[this.elements.length + 1];
        for (int i = 0; i < this.elements.length; i++) {
            newArray[i] = this.elements[i];
        }
        newArray[newArray.length - 1] = data;
        this.elements = newArray;
    }

    public T pop(){
        if (this.elements.length == 0) {
            throw new RuntimeException("The stack is empty.");
        }
        T data = this.elements[this.elements.length - 1];
        T[] newArray =  (T[])new Object[this.elements.length - 1];
        for (int i = 0, j = 0; i < newArray.length; i++) {
            newArray[i] = this.elements[j];
        }
        this.elements = newArray;
        return data;
    }

    public T peek(){
        if (this.elements.length == 0) {
            throw new RuntimeException("The stack is empty.");
        }
        return this.elements[this.elements.length - 1];
    }
}
