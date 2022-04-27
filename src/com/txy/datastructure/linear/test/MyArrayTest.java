package com.txy.datastructure.linear.test;

import com.txy.datastructure.linear.MyArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayTest {

    private MyArray<Integer> myArray;

    @Before
    public void init(){
        this.myArray = new MyArray<>();
        this.myArray.addData(0);
        this.myArray.addData(1);
    }

    @Test
    public void testAddData() {
        this.myArray.addData(2);
        this.myArray.addData(3);
        Assert.assertEquals(4, this.myArray.getArrayLength());
    }

    @Test
    public void testGetDataWithRightIndex() {
        int data = this.myArray.getData(0);
        Assert.assertEquals(0, data);
    }

    @Test(expected = RuntimeException.class)
    public void testGetDataWithWrongIndex() {
         this.myArray.getData(-1);
    }

    @Test
    public void testGetArrayLength() {
        Assert.assertEquals(2, this.myArray.getArrayLength());
    }

    @Test
    public void testDeleteDataWithRightIndex() {
        this.myArray.addData(2);
        this.myArray.deleteData(1);
        Assert.assertEquals(2, this.myArray.getArrayLength());
        Assert.assertEquals(2, (int)this.myArray.getData(1));
    }
    @Test(expected = RuntimeException.class)
    public void testDeleteDataWithWrongIndex() {
        this.myArray.deleteData(3);
    }

    @Test
    public void testSearchData() {
        Assert.assertEquals(1, this.myArray.searchData(1));
        Assert.assertEquals(-1, this.myArray.searchData(2));
    }

    @Test
    public void testSetDataWithRightIndex() {
        this.myArray.setData(0, -1);
        Assert.assertEquals(-1, (int)this.myArray.getData(0));
    }

    @Test(expected = RuntimeException.class)
    public void testSetDataWithWrongIndex() {
        this.myArray.setData(9, -1);
    }
}