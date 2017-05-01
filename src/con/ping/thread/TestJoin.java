package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/4/29.
 */
public class TestJoin implements Runnable{


    private static int sum = 0;

    public static void main(String[] args){

        Thread thread = new Thread(new TestJoin());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(sum);
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            sum ++;
        }
    }
}
