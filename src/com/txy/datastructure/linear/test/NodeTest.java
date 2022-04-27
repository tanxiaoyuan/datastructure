package com.txy.datastructure.linear.test;

import com.txy.datastructure.linear.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    private Node<String> node;

    @Before
    public void init(){
        this.node = new Node<>("A");
    }

    @Test
    public void testGetData() {
        Assert.assertEquals("A", this.node.getData());
    }

    @Test
    public void testGetNext() {
        Assert.assertEquals(null, this.node.getNext());
    }

    @Test
    public void testAppend() {
        Node<String> node1 = new Node<>("B");
        Node<String> node2 = new Node<>("C");
        this.node.append(node1).append(node2);
        Assert.assertEquals("B", this.node.getNext().getData());
        Assert.assertEquals("C", this.node.getNext().getNext().getData());
    }

    @Test
    public void testIsLast(){
        Assert.assertEquals(true, this.node.isLast());
    }

    @Test
    public void testRemoveNext(){
        Node<String> node1 = new Node<>("B");
        Node<String> node2 = new Node<>("C");
        this.node.append(node1).append(node2);
        this.node.removeNext();
        Assert.assertEquals("C", this.node.getNext().getData());
    }

    @Test
    public void testShow(){
        Node<String> node1 = new Node<>("B");
        Node<String> node2 = new Node<>("C");
        this.node.append(node1).append(node2);
        this.node.show();
    }

    @Test
    public void testAfter(){
        Node<String> node1 = new Node<>("B");
        Node<String> node2 = new Node<>("C");
        this.node.append(node1).append(node2);
        node1.after(new Node<>("D"));
        Assert.assertEquals("D", this.node.getNext().getNext().getData());
        this.node.show();
    }
}