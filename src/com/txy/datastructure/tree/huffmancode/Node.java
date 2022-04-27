package com.txy.datastructure.tree.huffmancode;

public class Node implements Comparable<Node>{

    private Byte data;

    private int weight;

    private Node leftNode;

    private Node rightNode;

    public Node(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }

    public Byte getData(){
        return this.data;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setLeftNode(Node leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode){
        this.rightNode = rightNode;
    }

    public Node getLeftNode(){
        return this.leftNode;
    }

    public Node getRightNode(){
        return this.rightNode;
    }
}
