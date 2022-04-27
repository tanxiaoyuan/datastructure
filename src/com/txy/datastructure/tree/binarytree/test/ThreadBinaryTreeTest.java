package com.txy.datastructure.tree.binarytree.test;

import com.txy.datastructure.tree.binarytree.BinaryTree;
import com.txy.datastructure.tree.binarytree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThreadBinaryTreeTest {

    private BinaryTree<Integer> binaryTree;

    @Before
    public void init(){
        this.binaryTree = new BinaryTree<>();
        TreeNode<Integer> root = new TreeNode<>(0);
        this.binaryTree.setRoot(root);
        TreeNode<Integer> rootL = new TreeNode<>(1);
        TreeNode<Integer> rootR = new TreeNode<>(2);
        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        rootL.setLeftNode(new TreeNode<>(3));
        rootL.setRightNode(new TreeNode<>(4));
        rootR.setRightNode(new TreeNode<>(5));
    }


    @Test
    public void testSetRoot() {
        this.binaryTree = new BinaryTree<>();
        TreeNode<Integer> root = new TreeNode<>(1);
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
        TreeNode<Integer> node = this.binaryTree.frontSearch(1);
        Assert.assertEquals(1, (int)node.getValue());
        TreeNode<Integer> node1 = this.binaryTree.frontSearch(10);
        Assert.assertEquals(null, node1);
    }

    @Test
    public void testMidSearch() {
        TreeNode<Integer> node = this.binaryTree.midSearch(1);
        Assert.assertEquals(1, (int)node.getValue());
        TreeNode<Integer> node1 = this.binaryTree.midSearch(10);
        Assert.assertEquals(null, node1);
    }

    @Test
    public void testAfterSearch() {
        TreeNode<Integer> node = this.binaryTree.afterSearch(1);
        Assert.assertEquals(1, (int)node.getValue());
        TreeNode<Integer> node1 = this.binaryTree.afterSearch(10);
        Assert.assertEquals(null, node1);
    }

    @Test
    public void testDeleteNode() {
        TreeNode<Integer> treeNode = this.binaryTree.deleteNode(1);
        Assert.assertEquals(1, (int)treeNode.getValue());
        TreeNode<Integer> node = this.binaryTree.afterSearch(1);
        Assert.assertEquals(null, node);
        TreeNode<Integer> treeNode1 = this.binaryTree.deleteNode(0);
        Assert.assertEquals(0, (int)treeNode1.getValue());
        TreeNode<Integer> node1 = this.binaryTree.afterSearch(0);
        Assert.assertEquals(null, node1);
    }


}