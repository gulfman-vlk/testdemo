package algs.merge;


import algs.sort.Example;

public class MergeBottom extends Example {
    private static Comparable[] aux;

    @Override
    protected void sort(Comparable[] a) {
        int n=a.length;
        aux=new Comparable[n];
        for(int s=1;s<n;s+=s)
            for(int lo=0;lo<n-s;lo+= s+s)
              merge(a,lo,lo+s-1,Math.min(lo+s+s-1,n-1));
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
    public static void main(String[] args) {

        MergeBottom m= new MergeBottom();
        m.test(args);
    }

}