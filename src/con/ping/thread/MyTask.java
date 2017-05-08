package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/4/29.\
 * 定义一个线程
 */
public class MyTask implements Runnable{

    private static Object lock = new Object();

    private int sum = 0;

    @Override
    public void run() {
        sum ++;
        System.out.println(this.sum);
    }


    public static void main(String[] args){
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new MyTask());
            MyThreadPoolExecutor.getInstance().execute(thread);
        }

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        threadGroup.getName();

//        synchronized (lock){
//            try {
//                Thread.currentThread().wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
