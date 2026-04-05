package com.dag;

public class Graph {

    public static final int INFINITY = Integer.MAX_VALUE;
    public java.util.List<Vertex> vertices = new java.util.LinkedList<>();

    public void dagShortestPath(Vertex source) throws CycleFoundException{

        java.util.Queue<Vertex> q = new java.util.LinkedList<>();

        for (Vertex v : vertices) {
            v.dist = INFINITY;
            v.prev = null;

            if (v.scratch == 0)
                q.add(v);
        }

        source.dist = 0;
        int processed = 0;

        while (!q.isEmpty()) {
            Vertex w = q.poll();
            processed++;

            for (Edge e : w.adj) {
                Vertex v = e.target;

                if (--v.scratch == 0) {
                    q.add(v);
                }

                if (w.dist != INFINITY) {
                    int newDist = w.dist + e.weight;

                    if (newDist < v.dist) {
                        v.dist = newDist;
                        v.prev = w;
                        q.add(v);
                    }
                }
            }
        }

        if (processed == vertices.size()) {
            throw new CycleFoundException("Cycle detected!!");
        }
    }
}
