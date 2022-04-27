package com.txy.datastructure.linear.test;

import com.txy.datastructure.linear.LoopNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoopNodeTest {

    private LoopNode<String> loopNode;

    @Before
    public void setUp() {
        this.loopNode = new LoopNode<>("A");
    }

    @Test
    public void testGetData() {
        Assert.assertEquals("A", this.loopNode.getData());
    }

    @Test
    public void testGetNext() {
        Assert.assertEquals("A", this.loopNode.getNext().getData());
    }

    @Test
    public void testAfter() {
        LoopNode<String> nodeB = new LoopNode<>("B");
        LoopNode<String> nodeC = new LoopNode<>("C");
        this.loopNode.after(nodeB);
        nodeB.after(nodeC);
        Assert.assertEquals("B", this.loopNode.getNext().getData());
        Assert.assertEquals("A", this.loopNode.getNext().getNext().getNext().getData());
    }

    @Test
    public void removeNext() {
        LoopNode<String> nodeB = new LoopNode<>("B");
        LoopNode<String> nodeC = new LoopNode<>("C");
        this.loopNode.after(nodeB);
        nodeB.after(nodeC);
        this.loopNode.removeNext();
        Assert.assertEquals("C", this.loopNode.getNext().getData());
        Assert.assertEquals("A", this.loopNode.getNext().getNext().getData());
    }
}