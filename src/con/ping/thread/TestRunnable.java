package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/5/4.
 */
public class TestRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " : " + Thread.currentThread().getName());
    }

    public static void main(String[] args){
        new Thread(new TestRunnable()).start();
    }
}
