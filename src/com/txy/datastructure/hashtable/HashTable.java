package com.txy.datastructure.hashtable;

/**
 * 1.直接定址法
 * 2.数据分析法
 * 3.平方取中法
 * 4.取余法
 * 5.随机数法
 *
 *
 * 散列冲突的解决方法：
 * 1. 开发地址法
 * (1) 线性探测法
 * (2) 二次探测法
 * (3) 再哈希法
 * 2. 链地址法
 * */
public class HashTable<T> {

    T[] data;

    public HashTable(){
        this.data = (T[])new Object[1000];
    }

    public void put(T obj){
        this.data[obj.hashCode()] = obj;
    }

    public T get(T obj){
        return this.data[obj.hashCode()];
    }
}
