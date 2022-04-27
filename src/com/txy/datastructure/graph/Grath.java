package com.txy.datastructure.graph;

import com.txy.datastructure.linear.MyQueue;
import com.txy.datastructure.linear.MyStack;

public class Grath<T> {

    private Vertex<T>[] vertex;

    private int currentSize;

    int[][] edges;

    public Grath(int size){
        this.vertex = new Vertex[size];
        this.edges = new int[size][size];
        for(int i = 0; i < size; i++){
            this.edges[i][i] = 1;
        }
    }

    public Grath<T> addVertex(Vertex<T> vertex){
        if(this.currentSize > this.vertex.length){
            throw new RuntimeException("Vertex addition exceeded");
        }
        this.vertex[currentSize++] = vertex;
        return this;
    }

    public int getCurrentSize(){
        return this.currentSize;
    }

    public Grath<T> addEdge(Vertex<T> start, Vertex<T> end){
        int startIndex = this.findVertexIndex(start);
        int endIndex = this.findVertexIndex(end);
        this.edges[startIndex][endIndex] = 1;
        this.edges[endIndex][startIndex] = 1;
        return this;
    }

    private int findVertexIndex(Vertex<T> vertex){
        int index = 0;
        for(int i = 0; i < currentSize; i++){
            if(vertex.getValue().equals(this.vertex[i].getValue())){
                index = i;
                break;
            }
        }
        return index;
    }

    public int[][] getEdges(){
        return this.edges;
    }

    /**
     * 深度优先遍历
     * */
    public void dfs() {
        for(int i = 0; i < this.vertex.length; i++){
            if(this.vertex[i].isVisited()){
                continue;
            } else {
                dfs(i);
            }
        }
    }

    private void dfs(int index){
        System.out.print(this.vertex[index].getValue() + " ");
        this.vertex[index].setVisited(true);
        for(int j = 0; j < this.vertex.length; j++){
            if(this.edges[index][j] == 1 && !this.vertex[j].isVisited()){
                dfs(j);
            }
        }
    }

    /**
     * 广度优先遍历
     * */
    public void bfs(){
        for(int i = 0; i < this.vertex.length; i++){
            if(this.vertex[i].isVisited()){
                continue;
            } else {
                bfs(i);
            }
        }
    }

    private void bfs(int index){
        MyQueue<Integer> queue = new MyQueue<>();
        System.out.print(this.vertex[index].getValue() + " ");
        this.vertex[index].setVisited(true);
        queue.add(index);
        while (queue.size() > 0){
            int u = queue.poll();
            int w = this.getFirstNeighbor(u);
            while (w != -1){
                System.out.print(this.vertex[w].getValue() + " ");
                queue.add(w);
                this.vertex[w].setVisited(true);
                w = getNextNeighbor(u, w);
            }
        }
    }

    private int getFirstNeighbor(int index){
        for(int i = index + 1; i < this.vertex.length; i++){
            if(this.edges[index][i] == 1 && !this.vertex[i].isVisited()){
                return i;
            }
        }
        return -1;
    }

    private int getNextNeighbor(int u, int w){
        for(int i = w + 1; i < this.vertex.length; i++){
            if(this.edges[u][i] == 1 && !this.vertex[i].isVisited()){
                return i;
            }
        }
        return -1;
    }
}
