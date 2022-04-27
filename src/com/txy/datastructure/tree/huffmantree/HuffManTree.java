package com.txy.datastructure.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffManTree<T extends Comparable> {


    public Node<T>  createHuffmanTree(T[] arr){
        List<Node> nodes =  new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            nodes.add(new Node(arr[i]));
        }
        while(nodes.size() > 1){
            Collections.sort(nodes);
            Node<T> leftNode = nodes.get(0);
            Node<T> rightNode = nodes.get(1);
            Node<T> node = new Node<>(leftNode.add(rightNode));
            node.setLeftNode(leftNode);
            node.setRightNode(rightNode);
            nodes.add(node);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }
}
