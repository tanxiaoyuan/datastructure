package com.txy.datastructure.linear.test;

import com.txy.datastructure.linear.MyQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {

    public MyQueue<Integer> myQueue;

    @Before
    public void init(){
        this.myQueue = new MyQueue<>();
    }

    @Test
    public void testSize() {
        Assert.assertEquals(0, this.myQueue.size());
    }

    @Test
    public void testAdd() {
        this.myQueue.add(-1);
        Assert.assertEquals(1, this.myQueue.size());
    }

    @Test
    public void testPoll() {
        this.myQueue.add(-1);
        this.myQueue.add(-2);
        Assert.assertEquals(2, this.myQueue.size());
        Assert.assertEquals(-1, (int)this.myQueue.poll());
        Assert.assertEquals(1, this.myQueue.size());
    }

    @Test(expected = RuntimeException.class)
    public void testPollWithEmpty() {
        this.myQueue.poll();
    }

}