package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/4/29.
 */
public class TestDeadLock implements Runnable{

    public static  int flag = 1;


    public static Object lock = new Object();
    public static void main(String[] argv){
        TestDeadLock lock = new TestDeadLock();
        for(int i=0;i<10;i++){
            System.out.println(flag);
            lock.run();
        }

    }

    @Override
    public void run(){
//        synchronized (lock){
            flag = flag +1;
//            System.out.println(flag);
//        }
    }
}
