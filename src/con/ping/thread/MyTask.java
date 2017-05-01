package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/4/29.\
 * 定义一个线程
 */
public class MyTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
