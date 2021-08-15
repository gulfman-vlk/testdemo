package algs.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestSearch {
    public static void main(String[] args) {
        Graph g=new Graph(new In(args[0]));
        int s=Integer.parseInt(args[1]);
        DepthFirstSearch depthFirstSearch=new DepthFirstSearch(g,s);
        for(int v=0;v<g.getV();v++){
            if(depthFirstSearch.marked(v))
                StdOut.print(v+" ");
        }
        StdOut.println();
        if(depthFirstSearch.count()!=g.getV())
            StdOut.print("没有");
        StdOut.println("连接");
    }
}
