package com.txy.datastructure.linear;

public class LoopNode<T> {

    private T data;

    private LoopNode<T> next = this;

    public  LoopNode(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public LoopNode<T> getNext(){
        return this.next;
    }


    public void removeNext(){
        LoopNode<T> next = this.next;
        LoopNode<T> nextOfNext = next.next;
        this.next = nextOfNext;
    }

    public void after(LoopNode<T> node){
        LoopNode<T> next = this.next;
        this.next = node;
        node.next = next;
    }
}
