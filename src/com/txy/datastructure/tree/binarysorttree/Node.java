package com.txy.datastructure.tree.binarysorttree;

public class Node<T extends Comparable> {

    private T value;

    private Node<T> leftNode;

    private Node<T> rightNode;

    public Node(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public void add(Node<T> node){
        if(node == null){
            return;
        } else {
            if(this.value.compareTo(node.value) > 0){
                if(this.leftNode == null){
                    this.leftNode = node;
                } else{
                    this.leftNode.add(node);
                }
            } else {
                if(this.rightNode == null){
                    this.rightNode = node;
                } else{
                    this.rightNode.add(node);
                }
            }
            //构建平衡二叉树,进行旋转
            if(leftNodeHeight() - rightNodeHeight() >= 2){
                if(this.leftNode != null && this.leftNode.leftNodeHeight() < this.leftNode.rightNodeHeight()){
                    leftNode.leftRotate();
                }
                rightRotate();
            } else if(leftNodeHeight() - rightNodeHeight() <= -2){
                if(this.rightNode != null && this.rightNode.rightNodeHeight() < this.rightNode.leftNodeHeight()){
                    rightNode.rightRotate();
                }
                leftRotate();
            }

        }
    }

    private void rightRotate(){
        Node<T> newRightNode = new Node<>(this.value);
        newRightNode.rightNode = this.rightNode;
        newRightNode.leftNode = this.leftNode.rightNode;
        this.value = leftNode.value;
        this.leftNode = this.leftNode.leftNode;
        this.rightNode = newRightNode;
    }

    private void leftRotate(){
        Node<T> newLeftNode = new Node<>(this.value);
        newLeftNode.leftNode = this.leftNode;
        newLeftNode.rightNode = this.rightNode.leftNode;
        this.value = rightNode.value;
        this.rightNode = this.rightNode.rightNode;
        this.leftNode = newLeftNode;
    }

    private int height(){
        return Math.max(this.leftNode == null ? 0 : this.leftNode.height(), this.rightNode == null ? 0 : this.rightNode.height()) + 1;
    }

    private int leftNodeHeight(){
        if(this.leftNode == null){
            return 0;
        }
        return this.leftNode.height();
    }

    private int rightNodeHeight(){
        if(this.rightNode == null){
            return 0;
        }
        return this.rightNode.height();
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

    public Node<T> search(T value){
        if(this.value.equals(value)){
            return this;
        } else{
            if(this.value.compareTo(value) > 0 && this.leftNode != null){
                return this.leftNode.search(value);
            } else if(this.leftNode != null){
                return this.rightNode.search(value);
            }
        }
        return null;
    }

    public Node<T> searchParent(T value){
        if((this.leftNode != null && this.leftNode.value.equals(value)) || (this.rightNode != null && this.rightNode.value.equals(value))){
            return this;
        } else if(this.value.compareTo(value) > 0 && this.leftNode != null){
            return this.leftNode.searchParent(value);
        } else if(this.value.compareTo(value) < 0 && this.rightNode != null){
            return this.rightNode.searchParent(value);
        }
        return null;
    }

    public Node<T> getLeftNode(){
        return this.leftNode;
    }

    public Node<T> getRightNode(){
        return this.rightNode;
    }

    public void setLeftNode(Node<T> node){
        this.leftNode = node;
    }

    public void setRightNode(Node<T> node){
        this.rightNode = node;
    }

    public void setValue(T value){
        this.value = value;
    }
}
