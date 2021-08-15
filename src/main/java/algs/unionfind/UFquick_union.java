package algs.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFquick_union {
    private int[] id;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public UFquick_union(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while(p!=id[p])
            p=id[p];
        return p;
    }

    public void union(int p, int q) {
      int pRoot=find(p);
      int qRoot=find(q);
      if(pRoot==qRoot) return;
      id[pRoot] =qRoot;
      count--;

    }
//    public void test(String[] ages){
//
//        int N = StdIn.readInt();
//        UF uf = new UF(N);
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if (uf.connected(p, q)) continue;
//            ;
//            uf.union(p, q);
//            StdOut.println(p + " " + q);
//        }
//        StdOut.println(uf.getCount() + "components");
//    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UFquick_union uf = new UFquick_union(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            ;
            uf.union(p, q);
//            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.getCount() + "条连接");

    }
}
