package algs.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public abstract class Example {
    protected abstract void sort(Comparable[] a);

    /**
     * 该方法比较两个实现了comparable接口的对象，如果第一个参数小于第二个参数，则返回true，相等时和大于时则返回false
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v,Comparable w){
        return  v.compareTo(w)<0;
    }

    /**
     * 交换方法，对一个实现comparable接口对象数组进行交换
     * @param a 对象
     * @param i 数组坐标
     * @param j 数组坐标
     */
    public  static void exch(Comparable[]a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public  static void show(Comparable[]a){
        for(int i=0;i<a.length;i++  )
            StdOut.print(a[i]+" ");
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1]))return false;
            return true;
    }
    public void test(String[] args){
        String[]a= In.readStrings(args[0]);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
