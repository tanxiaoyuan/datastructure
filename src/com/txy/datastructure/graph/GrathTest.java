package com.txy.datastructure.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GrathTest {

    private Grath<String> grath;

    @Before
    public void init() {
        this.grath = new Grath<>(5);
    }

    @Test
    public void testAddVertex() {
        Vertex<String> vertex = new Vertex<>("A");
        this.grath.addVertex(vertex);
        Assert.assertEquals(1, this.grath.getCurrentSize());
    }

    @Test
    public void testAddEdge() {
        this.grath.addVertex(new Vertex<>("A"))
                .addVertex(new Vertex<>("B"))
                .addVertex(new Vertex<>("C"))
                .addVertex(new Vertex<>("D"))
                .addVertex(new Vertex<>("E"));
        this.grath.addEdge(new Vertex<>("A"), new Vertex<>("D"));
        for(int[] edge : this.grath.getEdges()){
            System.out.println(Arrays.toString(edge));
        }
    }

    @Test
    public void testDfs(){
        this.grath.addVertex(new Vertex<>("A"))
                .addVertex(new Vertex<>("B"))
                .addVertex(new Vertex<>("C"))
                .addVertex(new Vertex<>("D"))
                .addVertex(new Vertex<>("E"));
        this.grath.addEdge(new Vertex<>("B"), new Vertex<>("D"));
        this.grath.addEdge(new Vertex<>("A"), new Vertex<>("B"));
        this.grath.addEdge(new Vertex<>("C"), new Vertex<>("D"));
        this.grath.addEdge(new Vertex<>("A"), new Vertex<>("C"));
        this.grath.dfs();
    }

    @Test
    public void testBfs(){
        this.grath.addVertex(new Vertex<>("A"))
                .addVertex(new Vertex<>("B"))
                .addVertex(new Vertex<>("C"))
                .addVertex(new Vertex<>("D"))
                .addVertex(new Vertex<>("E"));
        this.grath.addEdge(new Vertex<>("B"), new Vertex<>("D"));
        this.grath.addEdge(new Vertex<>("A"), new Vertex<>("B"));
        this.grath.addEdge(new Vertex<>("C"), new Vertex<>("D"));
        this.grath.addEdge(new Vertex<>("A"), new Vertex<>("C"));
        this.grath.bfs();
    }
}