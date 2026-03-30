package com.dijkstrasalgorithm;

public class Graph {

    public static final int INFINITY = Integer.MAX_VALUE;
    public java.util.List<Vertex> vertices = new java.util.LinkedList<>();

    public void dijkstra(Vertex s) {

        for (Vertex v : vertices) {
            v.dist = INFINITY;
            v.scratch = false;
        }

        s.dist = 0;
        java.util.PriorityQueue<Vertex> q = new java.util.PriorityQueue<>();
        q.add(s);

        while (!q.isEmpty()) {

            Vertex w = q.poll();

            if (w.scratch)
                continue;

            w.scratch = true;

            for (Edge e : w.adj) {
                Vertex v = e.target;

                int newDist = w.dist + e.weight;

                if (newDist < v.dist) {
                    v.dist = newDist;
                    v.prev = w;
                    q.add(v);
                }
            }
        }
    }


}