package com.dag;

public class Vertex {

    public String name;
    public java.util.List<Edge> adj;
    public int dist;
    public Vertex prev;
    public int scratch;

    public Vertex(String name) {
        this.name = name;
        this.adj = new java.util.LinkedList<>();
        this.dist = Graph.INFINITY;
        this.prev = null;
        this.scratch = 0;
    }
}
