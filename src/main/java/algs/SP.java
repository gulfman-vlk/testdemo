package algs;

interface  SP {


    /**
     * 从顶点s到v的距离，如果不存在则路径为无穷大
     * @param v 终点
     * @return
     */
    double distTo(int v);

    /**
     * 是否存在从顶点s到v的路径
     * @param v 终点坐标
     * @return
     */
   boolean hasPathTo(int v);

    /**
     * 从顶点s到v的路径，如果不存在为null
     * @param v
     * @return
     */
      Iterable<DirectedEdge> pathTo(int v);
}
