package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/4/29.
 * 测试死锁
 */
public class DeadLockTest {

    private static Object lockA = new Object();
    private static Object lockB = new Object();
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Thread(new MyTask(i%2)).start();
        }
    }
    static class MyTask implements Runnable{
        public MyTask(int tag){
            this.tag = tag;
        }
        private int tag;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":" + tag);
            if(tag == 0){
                synchronized (lockA){
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB){
                        System.out.println(Thread.currentThread().getName() + ": lockB");
                    }
                }
            }
            if(tag == 1){
                synchronized (lockB){
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA){
                        System.out.println(Thread.currentThread().getName() + ": lockA");
                    }
                }
            }
        }
    }

}
