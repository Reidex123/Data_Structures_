package com.dijkstrasalgorithm;

public class Vertex implements Comparable<Vertex> {

    public String name;
    public java.util.List<Edge> adj;
    public int dist;
    public Vertex prev;
    public boolean scratch;

    public Vertex(String name) {
        this.name = name;
        this.adj = new java.util.LinkedList<>();
        this.dist = Graph.INFINITY;
        this.prev = null;
        this.scratch = false;
    }

    @Override
    public int compareTo(Vertex other) {
        return Integer.compare(this.dist, other.dist);
    }

}