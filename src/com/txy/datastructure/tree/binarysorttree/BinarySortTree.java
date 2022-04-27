package com.txy.datastructure.tree.binarysorttree;

public class BinarySortTree<T extends Comparable> {
    private Node<T> root;

    public void add(Node<T> node){
        if(this.root == null){
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    public void frontShow() {
        this.root.frontShow();
    }

    public Node<T> search(T value){
        if(this.root == null){
            return null;
        } else{
            return this.root.search(value);
        }
    }

    public void deleteNode(T value){
        if(this.root == null){
            return;
        } else {
             Node<T> target = this.search(value);
             if(target == null){
                 return;
             }
             Node<T> parent = this.searchParent(value);
             if (target.getLeftNode() == null && target.getRightNode() == null) {
                if(parent.getLeftNode().getValue().equals(target.getValue())){
                    parent.setLeftNode(null);
                } else{
                    parent.setRightNode(null);
                }
             } else if(target.getLeftNode() != null && target.getRightNode() != null){
                    Node<T> node = this.deleteMin(target.getRightNode());
                    target.setValue(node.getValue());
             } else {
                 if(target.getLeftNode() != null){
                     if(parent.getLeftNode().getValue().equals(target.getValue())){
                         parent.setLeftNode(target.getLeftNode());
                     } else{
                         parent.setRightNode(target.getLeftNode());
                     }
                 } else{
                     if(parent.getLeftNode().getValue().equals(target.getValue())){
                         parent.setLeftNode(target.getRightNode());
                     } else{
                         parent.setRightNode(target.getRightNode());
                     }
                 }
             }
        }
    }

    private Node<T> searchParent(T value){
        if(this.root == null){
            return null;
        } else{
            return this.root.searchParent(value);
        }
    }

    private Node<T> deleteMin(Node<T> node){
        Node<T> target = node;
        while(target.getLeftNode() != null){
            target = target.getLeftNode();
        }
        deleteNode(target.getValue());
        return target;
    }
}


