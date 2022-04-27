package com.txy.datastructure.linear;

public class Node<T> {

    private T data;

    private Node<T> next;

    public Node(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public Node<T> append(Node<T> node){
        Node<T> currentNode = this;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return this;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public void removeNext(){
        if(this.isLast()){
            return;
        }
        Node<T> next = this.next;
        Node<T> nextOfNext = next.next;
        this.next = nextOfNext;
    }

    public void show(){
        Node<T> currentNode = this;
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public void after(Node<T> node){
        Node<T> next = this.next;
        this.next = node;
        node.next = next;
    }
}
