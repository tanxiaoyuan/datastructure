package com.txy.datastructure.tree.huffmantree.test;

import com.txy.datastructure.tree.huffmantree.HuffManTree;
import com.txy.datastructure.tree.huffmantree.Node;
import org.junit.Before;
import org.junit.Test;

public class HuffManTreeTest {

    private HuffManTree<Integer> huffManTree;

    @Before
    public void init(){
        this.huffManTree = new HuffManTree<>();
    }

    @Test
    public void testCreateHuffmanTree(){
        Integer[] arr = new Integer[]{1, 2, 3};
        Node<Integer> node = this.huffManTree.createHuffmanTree(arr);
        node.frontShow();
    }
}