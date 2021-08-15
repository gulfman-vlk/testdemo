package algs.merge;


import algs.sort.Example;

public class Merge extends Example {
    private static Comparable[]aux;

    private static void sort1(Comparable[]a,int lo,int hi){
        if(hi<=lo)return;
        int mid=lo+(hi-lo)/2;
        sort1(a,lo,mid);
        sort1(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    public static void merge(Comparable[]a,int lo,int mid,int hi){
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++)
            aux[k]=a[k];
        for(int k=lo;k<=hi;k++)
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else  a[k]=aux[i++];
    }
    @Override
    protected void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        sort1(a,0,a.length-1);
    }
    public static void main(String[] args) {

        Merge m=new Merge();
        m.test(args);
    }

}
