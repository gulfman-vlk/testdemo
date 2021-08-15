package algs.threesum;

import algs.Stopwatch;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {
    public static double timeTrial(int n) {
        int max = 1000000;
        int[] a = new int[n];
        //生成随机的数据
        for (int i = 0; i < n; i++) {
            //将一个【-max，max】区间的整数赋值到数组中
            a[i] = StdRandom.uniform(-max, max);
        }
        //开始统计时间
        Stopwatch t = new Stopwatch();
        //使用三层循环开始统计
        ThreeSum.count(a);
        return t.getTime();
    }

    public static void main(String[] args) {
        //设置画图对象
        StdDraw.setXscale(0,20000);
        StdDraw.setYscale(0,200);
        StdDraw.setPenRadius(.01);
        //
        for (int n = 250; n<16001; n += n) {
            //打印数据规模为n时程序的用时
//            System.out.println("n为"+n);
            double time = timeTrial(n);
            StdDraw.point(n,time);
        }
    }
}
