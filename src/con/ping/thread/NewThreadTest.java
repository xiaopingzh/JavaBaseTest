package con.ping.thread;

import java.util.List;
import java.util.concurrent.*;

/**
 *
 * 写一次试试
 *
 * Created by zhangxiaoping on 17/1/6.
 */
public class NewThreadTest {

    private volatile static NewThreadTest newThreadTest;

    private static Object lock = new Object();

    private ThreadPoolExecutor executor;

    /**
     * 私有构造器
     */
    private NewThreadTest(){

    }

    /**
     * 延迟初始化实例
     * @return
     */
    private static  NewThreadTest getInstance(int maxPoolSize,int queenSize){
        if(newThreadTest == null){
            synchronized (lock){
                if(newThreadTest == null){
                    newThreadTest = new NewThreadTest();
                    newThreadTest.executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                            maxPoolSize,3L, TimeUnit.MICROSECONDS,new LinkedBlockingDeque<Runnable>(queenSize),Executors.defaultThreadFactory());
                    newThreadTest.executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
                }
            }
        }
        return newThreadTest;
    }



    public final static NewThreadTest init(){
        return getInstance(32,1024);
    }


    /**
     * 加入线程
     * @param runnable
     */
    public void execute(Runnable runnable){
        executor.execute(runnable);
    }

    /**
     * 不在接收新的任务，等待将线程池中和队列中的任务执行完毕
     */
    public void shutdown(){
        executor.shutdown();
    }


    /**
     * 不在执行LinkedQueen中的任务，返回队列中的任务
     * @return
     */
    public List<Runnable> shutdownNew(){
        return executor.shutdownNow();
    }

    /**
     * 提交并返回
     * @param task
     * @param <T>
     * @return
     */
    public <T> Future<T> submit(Callable<T> task){
        return executor.submit(task);
    }

    public boolean isShutDown(){
        return executor.isShutdown();
    }

    public static void main(String[] args){
        System.out.print("hello world");
    }
}
