package com.txy.datastructure.tree.huffmantree;

public class Node<T extends Comparable> implements  Comparable<Node>{

    private T value;

    private Node<T> leftNode;

    private Node<T> rightNode;

    public  Node(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }


    public T add(Node node){
        if(this.value instanceof Integer){
            Integer number = ((Integer) this.value) + ((Integer)node.getValue());
            return  (T)number;
        } else if(this.value instanceof String){
            return (T)(this.value  + (String)node.getValue());
        } else {
            throw new RuntimeException("The value can not be added.");
        }
    }

    @Override
    public int compareTo(Node node) {
        return this.value.compareTo(node.value) ;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void midShow(){
        if(this.leftNode != null){
            this.leftNode.midShow();
        }
        System.out.print(this.value + " ");
        if(this.rightNode != null){
            this.rightNode.midShow();
        }
    }

    public void frontShow(){
        System.out.print(this.value + " ");
        if(this.leftNode != null){
            this.leftNode.frontShow();
        }
        if(this.rightNode != null){
            this.rightNode.frontShow();
        }
    }

    public void setLeftNode(Node<T> leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(Node<T> rightNode){
        this.rightNode = rightNode;
    }

}
