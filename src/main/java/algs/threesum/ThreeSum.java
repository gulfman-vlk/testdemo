package algs.threesum;

public class ThreeSum {
    public static int count(int[] a) {
        //统计和为0的元祖的数量
        int n = a.length;
        int count = 0;

        //三层循环
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        Stopwatch t = new Stopwatch();
//        //从Io流中获取数据（1Kints.txt,2Kints.txt,3Kints.txt,1Mints.txt)
//        int[] a = In.readInts(args[0]);
//        System.out.println(count(a));
//        t.getTime();
//
        Character[] a={'R','B'};
        System.out.println(a[1].compareTo(a[0]));
    }
}
