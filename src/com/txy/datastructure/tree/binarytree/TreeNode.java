package com.txy.datastructure.tree.binarytree;

import sun.reflect.generics.tree.Tree;

public class TreeNode<T> {

    private T value;

    private TreeNode<T> leftNode;

    private TreeNode<T> rightNode;

    public TreeNode(T value){
        this.value = value;
    }

    public void setLeftNode(TreeNode<T> leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode<T> rightNode){
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

    public TreeNode<T> frontSearch(T value){
        if (this.value.equals(value)) {
            return this;
        }
        if(this.leftNode != null){
            TreeNode<T> node =  this.leftNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        if(this.rightNode != null){
            TreeNode<T> node =  this.rightNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        return null;
    }

    public TreeNode<T> midSearch(T value){
        if(this.leftNode != null){
            TreeNode<T> node =  this.leftNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        if (this.value.equals(value)) {
            return this;
        }
        if(this.rightNode != null){
            TreeNode<T> node =  this.leftNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        return null;
    }

    public TreeNode<T> afterSearch(T value){
        if(this.leftNode != null){
            TreeNode<T> node =  this.leftNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        if(this.rightNode != null){
            TreeNode<T> node =  this.rightNode.frontSearch(value);
            if(node != null){
                return node;
            }
        }
        if (this.value.equals(value)) {
            return this;
        }
        return null;
    }

    public TreeNode<T> deleteNode(T value){
        TreeNode<T> parent = this;
        TreeNode<T> treeNode = null;
        if(parent.leftNode != null && parent.leftNode.value.equals(value)) {
            treeNode = parent.leftNode;
            parent.leftNode = null;
            return treeNode;
        }
        if(parent.rightNode != null && parent.rightNode.value.equals(value)) {
            treeNode = parent.rightNode;
            parent.rightNode = null;
            return treeNode;
        }
        if(this.leftNode != null){
            parent = this.leftNode;
            treeNode = parent.deleteNode(value);
        }
        if(this.rightNode != null){
            parent = this.rightNode;
            treeNode =  parent.deleteNode(value);
        }
        return treeNode;
    }
}
