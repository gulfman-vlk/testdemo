package algs.sort;

public class SelectionSort extends Example{
    @Override
    protected void sort(Comparable[] a) {
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            int min=i;
            for(int j=i+1;j<n;j++)
                if(less(a[j],a[min])) min=j;
                exch(a,i,min);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort=new SelectionSort();
        selectionSort.test(args);
    }
}
