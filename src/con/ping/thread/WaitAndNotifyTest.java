package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/5/1.
 *
 * 使用wait、notify实现等待、通知机制
 */
public class WaitAndNotifyTest {

    public static boolean flag = false;
    public static final Object lock = new Object();
    public void test(){
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.start();

    }

    class Producer implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                lock.notify();
                flag = true;
            }
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while(! flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
