package com.txy.datastructure.graph;

public class Vertex<T> {

    private T value;

    private boolean visited;

    public Vertex(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public boolean isVisited(){
        return this.visited;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }
}
