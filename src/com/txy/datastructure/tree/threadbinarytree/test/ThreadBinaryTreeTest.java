package com.txy.datastructure.tree.threadbinarytree.test;

import com.txy.datastructure.tree.threadbinarytree.ThreadBinaryTree;
import com.txy.datastructure.tree.threadbinarytree.ThreadTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThreadBinaryTreeTest {

    private ThreadBinaryTree<Integer> binaryTree;

    @Before
    public void init(){
        this.binaryTree = new ThreadBinaryTree<>();
        ThreadTreeNode<Integer> root = new ThreadTreeNode<>(0);
        this.binaryTree.setRoot(root);
        ThreadTreeNode<Integer> rootL = new ThreadTreeNode<>(1);
        ThreadTreeNode<Integer> rootR = new ThreadTreeNode<>(2);
        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        rootL.setLeftNode(new ThreadTreeNode<>(3));
        rootL.setRightNode(new ThreadTreeNode<>(4));
        rootR.setRightNode(new ThreadTreeNode<>(5));
    }


    @Test
    public void testSetRoot() {
        this.binaryTree = new ThreadBinaryTree<>();
        ThreadTreeNode<Integer> root = new ThreadTreeNode<>(1);
        this.binaryTree.setRoot(root);
        Assert.assertEquals(1, (int) binaryTree.getRoot().getValue());
    }

    @Test
    public void testGetRoot() {
        Assert.assertEquals(0, (int) binaryTree.getRoot().getValue());
    }

    @Test
    public void testFrontShow() {
        this.binaryTree.frontShow();
    }

    @Test
    public void testMidShow() {
        this.binaryTree.midShow();
    }

    @Test
    public void testAfterShow() {
        this.binaryTree.afterShow();
    }

    @Test
    public void testFrontSearch() {
        ThreadTreeNode<Integer> node = this.binaryTree.frontSearch(1);
        Assert.assertEquals(1, (int)node.getValue());
        ThreadTreeNode<Integer> node1 = this.binaryTree.frontSearch(10);
        Assert.assertEquals(null, node1);
    }

    @Test
    public void testMidSearch() {
        ThreadTreeNode<Integer> node = this.binaryTree.midSearch(1);
        Assert.assertEquals(1, (int)node.getValue());
        ThreadTreeNode<Integer> node1 = this.binaryTree.midSearch(10);
        Assert.assertEquals(null, node1);
    }

    @Test
    public void testAfterSearch() {
        ThreadTreeNode<Integer> node = this.binaryTree.afterSearch(1);
        Assert.assertEquals(1, (int)node.getValue());
        ThreadTreeNode<Integer> node1 = this.binaryTree.afterSearch(10);
        Assert.assertEquals(null, node1);
    }

    @Test
    public void testDeleteNode() {
        ThreadTreeNode<Integer> threadTreeNode = this.binaryTree.deleteNode(1);
        Assert.assertEquals(1, (int) threadTreeNode.getValue());
        ThreadTreeNode<Integer> node = this.binaryTree.afterSearch(1);
        Assert.assertEquals(null, node);
        ThreadTreeNode<Integer> threadTreeNode1 = this.binaryTree.deleteNode(0);
        Assert.assertEquals(0, (int) threadTreeNode1.getValue());
        ThreadTreeNode<Integer> node1 = this.binaryTree.afterSearch(0);
        Assert.assertEquals(null, node1);
    }

    @Test
    public void testThreadNodes(){
        this.binaryTree.threadNodes();
        Assert.assertEquals(1,(int)this.binaryTree.midSearch(3).getRightNode().getValue());
    }

    @Test
    public void testThreadIterator(){
        this.binaryTree.threadNodes();
        this.binaryTree.threadIterator();
    }
}