package com.txy.datastructure.linear;

public class DoubleNode<T> {

    private DoubleNode<T> pre = this;

    private DoubleNode<T> next = this;

    private T data;

    public DoubleNode(T data){
        this.data = data;
    }

    public DoubleNode<T> next(){
        return this.next;
    }

    public DoubleNode<T> pre(){
        return this.pre;
    }

    public T getData(){
        return this.data;
    }

    public void after(DoubleNode<T> node){
        DoubleNode<T> next = this.next;
        this.next = node;
        node.pre = this;
        next.pre = node;
        node.next = next;
    }
}
