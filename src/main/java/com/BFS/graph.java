package com.BFS;

public class graph {

    public java.util.List<vertex> vertices;
    public static final int INFINITY = Integer.MAX_VALUE;

    public void bfs(vertex s) {

        for (vertex v : vertices) {
            v.dist = INFINITY;
        }

        s.dist = 0;
        s.path = null;

        java.util.Queue<vertex> q = new java.util.LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {

            vertex v = q.remove();

            for (vertex w : v.adj) {

                if (w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.path = v;
                    q.add(w);
                }
            }
        }
    }
}
