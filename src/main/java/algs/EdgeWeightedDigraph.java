package algs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class EdgeWeightedDigraph {
    private final int v;  //顶点个数
    private int e;     //边的总数
    private Bag<DirectedEdge>[] adj;    //领接表

    public EdgeWeightedDigraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[v];
        for (int i = 0; i < v; i++)
            adj[i] = new Bag<>();
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E=in.readInt();
        for(int i=0;i<E;i++)
        {
            int v=in.readInt();
            int w=in.readInt();
            double weight=in.readDouble();
            addEdge(new DirectedEdge(v,w,weight));
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(DirectedEdge edge) {
        adj[edge.from()].add(edge);
        e++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int i = 0; i < v; i++)
            for (DirectedEdge e : adj[v])
                bag.add(e);
        return bag;
    }

    @Override
    public String toString() {
        return "EdgeWeightedDigraph{" +
                "顶点个数=" + v +
                ", 边的个数=" + e +
                ", 有向边：" + Arrays.toString(adj) +
                '}';
    }
}
