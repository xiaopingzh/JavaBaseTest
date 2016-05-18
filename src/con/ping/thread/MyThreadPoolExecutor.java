package con.ping.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池处理器 implements ThreadPoolExecutor
 * 用于监控
 * @author zhangxiaoping
 *
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor{

	
	private static MyThreadPoolExecutor executor = new MyThreadPoolExecutor
			(Runtime.getRuntime().availableProcessors(), 32, 3L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024));
	
	
	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	
	/**
	 * executor()方法执行前
	 */
	@Override
	public void beforeExecute(Thread t, Runnable r) { 
		//获取活动的线程数据/需要执行的任务数量
		System.out.println(t.getName() + " " + executor.getActiveCount() + " " + executor.getTaskCount());
	 }
	
	/**
	 * 线程执行完毕后触发
	 */
	@Override
	public void afterExecute(Runnable r, Throwable t) { 
		System.currentTimeMillis();
	}
	
	
	public static void test01(){
		for(int i=0;i<10;i++){
			Task task = new Task();
			executor.execute(task);
		}
		executor.shutdown();
	}
	
	public static void main(String[] args){
		test01();
	}
	
}


class Task implements Runnable{
	
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName());
	}
}