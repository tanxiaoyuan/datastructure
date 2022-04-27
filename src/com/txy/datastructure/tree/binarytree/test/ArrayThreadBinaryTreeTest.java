package com.txy.datastructure.tree.binarytree.test;

import com.txy.datastructure.tree.binarytree.ArrayBinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayThreadBinaryTreeTest {

    private ArrayBinaryTree<String> arrayBinaryTree;

    @Before
    public void  init(){
        this.arrayBinaryTree = new ArrayBinaryTree<>(new String[]{"A", "B", "C", "D", "E", "F"});
    }

    @Test
    public void testFrontShow(){
        this.arrayBinaryTree.frontShow(0);
    }

    @Test
    public void testMidShow(){
        this.arrayBinaryTree.midShow(0);
    }

    @Test
    public void testAfterShow(){
        this.arrayBinaryTree.afterShow(0);
    }
}