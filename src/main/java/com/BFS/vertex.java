package com.BFS;

public class vertex {

    public String name;
    public java.util.List<vertex> adj;
    public int dist;
    public vertex path;

    public vertex(String name) {
        
        this.name = name;
        adj = new java.util.LinkedList<>();
        this.dist = graph.INFINITY;
        path = null;
    }
}
