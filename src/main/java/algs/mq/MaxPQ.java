package algs.mq;

import java.util.Comparator;

public class MaxPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int n=0;
    public MaxPQ(int maxN){
        pq=(Key[]) new Comparator[maxN+1];
    }
    public boolean isEmpty(){
        return n==0;
    }
    public int size(){
        return n;
    }
    public void insert(Key v)
    {
        pq[++n]=v;
        swit(n);
    }

    /**
     * 删除最大的元素
     * @return  被删除的根元素对象
     */
    public Key delMax(){
        Key max=pq[1];
        exch(1,n--);  //把根元素和最后元素进行交换
        pq[n+1]=null;   //回收最后的数组元素
        sink(1);    //把最后元素进行堆下沉
        return max; //返回已被删除的根元素对象
    }

    /**
     * 该方法将比较传入的两个参数的大小，当第一个参数小于第二个参数时，返回true,否则返回false。
     * @param i 数组坐标参数
     * @param j 数组坐标参数
     * @return
     */
    private boolean less(int i,int j){
        return  pq[i].compareTo(pq[j])<0;
    }
    private void exch(int i,int j){
        Key t=pq[i]; pq[i]=pq[j];
        pq[j]=t;
    }

    /**
     * 由下至上的上浮堆有序化
     * @param k 堆节点位置
     */
    private void swit(int k){
        while(k>1&&less(k/2,k)){   //不断的循环判断当前节点和它上一级别的节点做比较，并且k>1，即k的位置不能超过根节点
            exch(k/2,k);
            k=k/2;
        }
    }

    /**
     * 自顶向下的堆下沉有序化
     * @param k 堆节点位置
     */
    private void sink(int k){
        while (2*k<=n)
        {
            int j=2*k;
            if(j<n&&less(j,j+1))j++;  //选取两个子节点中的较大一个数值
            if(!less(k,j)) break;  //比较，如果他比两个子节点中较大的一个还要小则循环结束
            exch(k,j); //交换子节点中较大的节点，
            k=j;    //把坐标值移动到较大子节点位置,并且再次循环比较它的子节点。
        }
    }
}
