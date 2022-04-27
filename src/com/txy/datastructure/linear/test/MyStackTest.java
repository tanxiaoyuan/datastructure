package com.txy.datastructure.linear.test;

import com.txy.datastructure.linear.MyStack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

    private MyStack<String> myStack;

    @Before
    public void init(){
        this.myStack = new MyStack<>();
    }

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(true, this.myStack.isEmpty());
    }

    @Test
    public void testPush() {
        this.myStack.push("A");
        Assert.assertEquals(false, this.myStack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testPopWithEmpty() {
        this.myStack.pop();
    }

    @Test
    public void testPeek(){
        this.myStack.push("A");
        Assert.assertEquals("A",  this.myStack.peek());
    }

    @Test(expected = RuntimeException.class)
    public void testPeekWithEmpty(){
        this.myStack.peek();
    }
}