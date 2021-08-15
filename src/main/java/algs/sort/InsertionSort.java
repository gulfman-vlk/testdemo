package algs.sort;

public class InsertionSort extends Example{
    @Override
    protected void sort(Comparable[] a) {
        int n=a.length;
        for(int i=0;i<n;i++)
        {
          for(int j=i;j>0&&less(a[j],a[j-1]);j--){
              exch(a,j,j-1);
          }
        }
    }

    public static void main(String[] args) {
        InsertionSort selectionSort=new InsertionSort();
        selectionSort.test(args);
    }
}
