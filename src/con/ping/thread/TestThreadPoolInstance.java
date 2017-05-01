package con.ping.thread;

/**
 * Created by zhangxiaoping on 17/4/30.
 */
public class TestThreadPoolInstance {


    public static void main(String[] args){
        ThreadPoolInstance threadPoolInstance = ThreadPoolInstance.getInstance();
        for(int i=0;i<5;i++){
            threadPoolInstance.execute(new MyTask());
        }

        threadPoolInstance.execute(new MyTask());

    }
}
