package com.txy.datastructure.tree.binarysorttree.test;

import com.txy.datastructure.tree.binarysorttree.BinarySortTree;
import com.txy.datastructure.tree.binarysorttree.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySortTreeTest {

    private BinarySortTree<Integer> tree;

    @Before
    public void setUp(){
        this.tree = new BinarySortTree<>();
    }

    @Test
    public void testAdd() {
        int[] arr = new int[]{8,9,7,6,5,4};
        for(int i = 0; i < arr.length; i++){
            this.tree.add(new Node<>(arr[i]));
        }
        this.tree.frontShow();
    }

    @Test
    public void testSearch(){
        int[] arr = new int[]{2,1,6,0,4,7,5};
        for(int i = 0; i < arr.length; i++){
            this.tree.add(new Node<>(arr[i]));
        }
        Assert.assertEquals(6, (int)this.tree.search(6).getValue());
        Assert.assertEquals(null, this.tree.search(10));
    }

    @Test
    public void testDeleteNode(){
        int[] arr = new int[]{2,1,6,0,4,7,5};
        for(int i = 0; i < arr.length; i++){
            this.tree.add(new Node<>(arr[i]));
        }
        Assert.assertEquals(0, (int)this.tree.search(0).getValue());
        this.tree.deleteNode(0);
        Assert.assertEquals(null, this.tree.search(0));
        Assert.assertEquals(2, (int)this.tree.search(2).getValue());
        this.tree.deleteNode(2);
        Assert.assertEquals(null, this.tree.search(2));
    }
}