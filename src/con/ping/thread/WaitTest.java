package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/5/14.
 */
public class WaitTest {

    public synchronized void testJoin() throws InterruptedException {
        while(Thread.currentThread().isAlive()){
            wait();
        }
    }

    public static void main(String[] args){
        try {
            new WaitTest().testJoin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
