package algs;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class RouteTest {
    public static void main(String[] args) {
        EdgeWeightedDigraph g;
        g=new EdgeWeightedDigraph(new In(args[0]));
        int s=Integer.parseInt(args[1]);
        SP sp=new SP() {
            @Override
            public double distTo(int v) {
                return 0;
            }

            @Override
            public boolean hasPathTo(int v) {
                return false;
            }

            @Override
            public Iterable<DirectedEdge> pathTo(int v) {
                return null;
            }
        };
        for(int t=0;t<g.v();t++)
        {
            StdOut.print(s+"到"+t);
            StdOut.printf(" (%4.2f): ",sp.distTo(t));
            if(sp.hasPathTo(t))
                for(DirectedEdge e:sp.pathTo(t))
                    StdOut.print(e+" ");
                StdOut.println();
        }
    }
}
