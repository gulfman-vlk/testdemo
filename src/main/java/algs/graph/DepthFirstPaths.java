package algs.graph;

import java.util.Stack;

public class DepthFirstPaths {
    private  boolean[] marked;  //这个顶点上调用dfs()了吗？
    private int[] edgeTo;  //从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;  //起点

    /**
     * 深度优先搜索构造类
     * @param g 图文件
     * @param s 起点
     */
    public DepthFirstPaths(Graph g, int s){
        marked=new boolean[g.getV()];
        edgeTo=new int[g.getV()];
        this.s =s;
        dfs(g,s);
    }
    private void dfs(Graph g,int v){
        marked[v]=true;
        for(int w:g.adj(v))
            if(!marked[w])
            {
                edgeTo[w]=v;
                dfs(g,w);
            }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
   public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
       Stack<Integer> path=new Stack<>();
       for(int x=v;x!=s;x=edgeTo[x])
           path.push(x);
       path.push(s);
       return path;
   }
}
