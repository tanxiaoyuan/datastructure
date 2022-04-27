package com.txy.datastructure.tree.binarytree;

public class ArrayBinaryTree<T> {

    T[] data;

    public ArrayBinaryTree(T[] data){
        this.data = data;
    }

    public void frontShow(int start){
        if(this.data == null || this.data.length == 0){
            return;
        }
        System.out.print(data[start]);
        if(2 * start + 1< data.length){
            frontShow(2 * start + 1);
        }
        if(2 * start + 2 < data.length){
            frontShow(2 * start + 2);
        }
    }

    public void midShow(int start){
        if(this.data == null || this.data.length == 0){
            return;
        }
        if(2 * start + 1< data.length){
            midShow(2 * start + 1);
        }
        System.out.print(data[start]);
        if(2 * start + 2 < data.length){
            midShow(2 * start + 2);
        }
    }

    public void afterShow(int start){
        if(this.data == null || this.data.length == 0){
            return;
        }
        if(2 * start + 1< data.length){
            afterShow(2 * start + 1);
        }
        if(2 * start + 2 < data.length){
            afterShow(2 * start + 2);
        }
        System.out.print(data[start]);
    }
}
