package com.txy.datastructure.linear.test;

import com.txy.datastructure.linear.DoubleNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoubleNodeTest {

    private DoubleNode<String> doubleNode;

    @Before
    public void setUp() {
        this.doubleNode = new DoubleNode<>("A");
    }

    @Test
    public void testNext(){
        Assert.assertEquals("A", this.doubleNode.next().getData());
    }

    @Test
    public void testPre(){
        Assert.assertEquals("A", this.doubleNode.pre().getData());
    }

    @Test
    public void testAfter() {
        DoubleNode<String> nodeB = new DoubleNode<>("B");
        this.doubleNode.after(nodeB);
        Assert.assertEquals("B", this.doubleNode.next().getData());
        Assert.assertEquals("A", this.doubleNode.next().pre().getData());
    }

}