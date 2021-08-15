package algs.sort;


import edu.princeton.cs.algs4.StdOut;

public class SortCompare2 {
    public static void main(String[] args) {
        //第一个参数为对比的排序算法，第二个也为排序的算法
        String alg1=args[0];
        String alg2 = args[1];
//        第三个数为产生多少个随机数，第四个参数为重复多少次比较
        int n=Integer.parseInt(args[2]);
        int t=Integer.parseInt(args[3]);
        double t1=SortCompare.timeRandomInput(alg1,n,t);
        double t2=SortCompare.timeRandomInput(alg2,n,t);

        StdOut.printf("对于 %d 个数据Double值，\n [%s耗时/",n,alg2);
       System.out.printf("%s耗时]之比为 %.8f \n",alg1,t2/t1);
    }
}
