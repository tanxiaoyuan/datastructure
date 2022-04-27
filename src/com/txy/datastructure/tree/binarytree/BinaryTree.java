package com.txy.datastructure.tree.binarytree;

public class BinaryTree<T> {

    private TreeNode<T> root;

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
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

    public TreeNode<T> frontSearch(T value) {
        if (this.root != null) {
            return this.root.frontSearch(value);
        }
        return null;
    }

    public TreeNode<T> midSearch(T value) {
        if(this.root != null){
            return this.root.midSearch(value);
        }
        return null;
    }

    public TreeNode<T> afterSearch(T value) {
        if(this.root != null){
            return this.root.afterSearch(value);
        }
        return null;
    }

    public TreeNode<T> deleteNode(T value) {
        TreeNode<T> treeNode;
        if (this.root.getValue().equals(value)) {
            treeNode = this.root;
            this.root = null;
        } else {
            treeNode = this.root.deleteNode(value);
        }
        return treeNode;
    }
}
