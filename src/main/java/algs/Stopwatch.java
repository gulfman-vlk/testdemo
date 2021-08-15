package algs;

/**
 * 获取运行时间类
 *
 *    Stopwatch t =new Stopwatch();
 *    ....执行程序
 *    t.getTime();   //打印运行时间
 */
public class Stopwatch {
    private final long start;
    public Stopwatch(){
        start=System.currentTimeMillis();
    }
    public double getTime(){
        long now =System.currentTimeMillis();
        System.out.println("程序运行了"+((now-start)/1000.0)+"秒");
        return (now-start)/1000.0;
    }
}
