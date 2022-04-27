package com.txy.datastructure.tree.threadbinarytree;

public class ThreadTreeNode<T> {

    private T value;

    private ThreadTreeNode<T> leftNode;

    private ThreadTreeNode<T> rightNode;

    int leftType;

    int rightType;

    public ThreadTreeNode(T value){
        this.value = value;
    }

    public  ThreadTreeNode<T> getLeftNode(){
        return this.leftNode;
    }

    public ThreadTreeNode<T> getRightNode(){
        return this.rightNode;
    }

    public void setLeftNode(ThreadTreeNode<T> leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(ThreadTreeNode<T> rightNode){
        this.rightNode = rightNode;
    }

    public T getValue(){
        return this.value;
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

    public void midShow(){
        if(this.leftNode != null){
            this.leftNode.midShow();
        }
        System.out.print(this.value + " ");
        if(this.rightNode != null){
            this.rightNode.midShow();
        }
    }

    public void afterShow(){
        if(this.leftNode != null){
            this.leftNode.afterShow();
        }
        if(this.rightNode != null){
            this.rightNode.afterShow();
        }
        System.out.print(this.value + " ");
    }

    public ThreadTreeNode<T> frontSearch(T value){
        if (this.value.equals(value)) {
            return this;
        }
        if(this.leftNode != null){
            ThreadTreeNode<T> node =  this.leftNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        if(this.rightNode != null){
            ThreadTreeNode<T> node =  this.rightNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        return null;
    }

    public ThreadTreeNode<T> midSearch(T value){
        if(this.leftNode != null){
            ThreadTreeNode<T> node =  this.leftNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        if (this.value.equals(value)) {
            return this;
        }
        if(this.rightNode != null){
            ThreadTreeNode<T> node =  this.leftNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        return null;
    }

    public ThreadTreeNode<T> afterSearch(T value){
        if(this.leftNode != null){
            ThreadTreeNode<T> node =  this.leftNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        if(this.rightNode != null){
            ThreadTreeNode<T> node =  this.rightNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        if (this.value.equals(value)) {
            return this;
        }
        return null;
    }

    public ThreadTreeNode<T> deleteNode(T value){
        ThreadTreeNode<T> parent = this;
        ThreadTreeNode<T> threadTreeNode = null;
        if(parent.leftNode != null && parent.leftNode.value.equals(value)) {
            threadTreeNode = parent.leftNode;
            parent.leftNode = null;
            return threadTreeNode;
        }
        if(parent.rightNode != null && parent.rightNode.value.equals(value)) {
            threadTreeNode = parent.rightNode;
            parent.rightNode = null;
            return threadTreeNode;
        }
        if(this.leftNode != null){
            parent = this.leftNode;
            threadTreeNode = parent.deleteNode(value);
        }
        if(this.rightNode != null){
            parent = this.rightNode;
            threadTreeNode =  parent.deleteNode(value);
        }
        return threadTreeNode;
    }
}
