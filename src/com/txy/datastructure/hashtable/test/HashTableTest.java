package com.txy.datastructure.hashtable.test;

import com.txy.datastructure.hashtable.HashTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    private HashTable<PersonInfo> hashTable;

    @Before
    public void setUp() {
        this.hashTable = new HashTable<>();
    }

    @Test
    public void testPut() {
        PersonInfo personInfo = new PersonInfo(1, "张三");
        this.hashTable.put(personInfo);
    }

    @Test
    public void testGet() {
        PersonInfo personInfo = new PersonInfo(1, "张三");
        this.hashTable.put(personInfo);
        PersonInfo personInfo1 = this.hashTable.get(new PersonInfo(1, "111"));
        Assert.assertEquals(personInfo, personInfo1);
    }
}