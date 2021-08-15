package algs.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int v;
    private int e;
    private Bag<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();

        }
    }

    public Graph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph g) {
        int max = 0;
        for (int v = 0; v < g.getV(); v++)
            if (degree(g, v) > max)
                max = degree(g, v);
        return max;

    }

    public static double avgDegree(Graph graph) {
        return 2.0 * graph.getE() / graph.getV();
    }

    public static int numberOfSelfLoops(Graph graph) {
        int count = 0;
        for (int v = 0; v < graph.getV(); v++)
            for (int w : graph.adj(v))
                if (v == w) count++;
        return count / 2;

    }

    @Override
    public String toString() {
        String s = v + "顶点, " + e + " 边\n";
        for (int i = 0; i < v; i++) {
            s += i + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
}
