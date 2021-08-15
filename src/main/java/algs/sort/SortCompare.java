package algs.sort;


import algs.quick.Quick3Way;
import edu.princeton.cs.algs4.*;

public class SortCompare {
    public static long time(String alg,Double[]a){
        long start=System.currentTimeMillis();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("Merge")) Merge.sort(a);
        if(alg.equals("Quick")) Quick.sort(a);
        if(alg.equals("Quick3Way")) new Quick3Way().sortProxy(a);
        if(alg.equals("Heap")) Heap.sort(a);
        long time=System.currentTimeMillis()-start;
        return time;
    }
    public static long timeRandomInput(String alg,int n,int t){
        long total=0L;
        Double[] a=new Double[n];
        for(int i=0;i<t;i++ )
        {
            for (int j=0;j<n;j++)
                a[j]=StdRandom.uniform();
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        //第一个参数为对比的排序算法，第二个也为排序的算法
        String alg1=args[0];
        String alg2 = args[1];
//        第三个数为产生多少个随机数，第四个参数为重复多少次比较
        int n=Integer.parseInt(args[2]);
        int t=Integer.parseInt(args[3]);
        long t1=timeRandomInput(alg1,n,t);
        long t2=timeRandomInput(alg2,n,t);
         float d=t2/(float)t1;
        StdOut.printf("对于 %d 个数据Double值，\n [%s耗时/",n,alg2);
       System.out.printf("%s耗时]之比为 %.8f \n",alg1,d);
    }
}
