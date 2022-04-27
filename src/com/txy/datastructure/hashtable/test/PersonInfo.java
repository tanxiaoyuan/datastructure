package com.txy.datastructure.hashtable.test;

public class PersonInfo {

    private int age;

    private String name;

    public PersonInfo(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode(){
        return this.age;
    }
}
