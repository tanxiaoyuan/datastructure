package com.txy.datastructure.tree.threadbinarytree;

public class ThreadBinaryTree<T> {

    private ThreadTreeNode<T> root;

    private ThreadTreeNode<T> pre;

    public void setRoot(ThreadTreeNode<T> root) {
        this.root = root;
    }

    public void threadNodes(){
        this.threadNodes(root);
    }

    public void threadIterator(){
        ThreadTreeNode<T> node = root;
        while(node != null){
            while(node.leftType == 0){
                node = node.getLeftNode();
            }
            System.out.print(node.getValue() + " ");
            while(node.rightType == 1){
                node = node.getRightNode();
                System.out.print(node.getValue() + " ");
            }
            node = node.getRightNode();
        }
    }

    private void threadNodes(ThreadTreeNode node){
        if(node == null){
            return;
        }
        threadNodes(node.getLeftNode());
        if(node.getLeftNode() == null){
            node.setLeftNode(pre);
            node.leftType = 1;
        }
        if(pre != null && pre.getRightNode() == null){
            pre.setRightNode(node);
            pre.rightType = 1;
        }
        pre = node;
        threadNodes(node.getRightNode());
    }

    public ThreadTreeNode<T> getRoot() {
        return this.root;
    }

    public void frontShow() {
        this.root.frontShow();
    }

    public void midShow() {
        this.root.midShow();
    }

    public void afterShow() {
        this.root.afterShow();
    }

    public ThreadTreeNode<T> frontSearch(T value) {
        if (this.root != null) {
            return this.root.frontSearch(value);
        }
        return null;
    }

    public ThreadTreeNode<T> midSearch(T value) {
        if(this.root != null){
            return this.root.midSearch(value);
        }
        return null;
    }

    public ThreadTreeNode<T> afterSearch(T value) {
        if(this.root != null){
            return this.root.afterSearch(value);
        }
        return null;
    }

    public ThreadTreeNode<T> deleteNode(T value) {
        ThreadTreeNode<T> threadTreeNode;
        if (this.root.getValue().equals(value)) {
            threadTreeNode = this.root;
            this.root = null;
        } else {
            threadTreeNode = this.root.deleteNode(value);
        }
        return threadTreeNode;
    }
}
