package com.bellmanFordalgorithm;

public class Graph {
    public static final int INFINITY = Integer.MAX_VALUE;
    public java.util.List<Vertex> vertices = new java.util.LinkedList<>();

    public void bellmanFord(Vertex s) throws NegativeCycleException{
        for (Vertex v : vertices) {
            v.dist = INFINITY;
            v.scratch = 0;
        }

        s.dist = 0;
        java.util.Queue<Vertex> q = new java.util.LinkedList<>();
        q.add(s);
        s.scratch++;

        while (!q.isEmpty()) {

            Vertex w = q.poll();
            w.scratch++;

            if (w.scratch > 2 * vertices.size() + 1) {
                throw new NegativeCycleException("Cycle detected while traversing the graph!!");
            }

            for (Edge e : w.adj) {
                Vertex v = e.target;
                int newDist = w.dist + e.weight;

                if (newDist < v.dist) {
                    v.dist = newDist;
                    v.prev = w;

                    if (v.scratch % 2 == 0) {
                        q.add(v);
                        v.scratch++;
                    }
                }
            }
        }
    }
}
