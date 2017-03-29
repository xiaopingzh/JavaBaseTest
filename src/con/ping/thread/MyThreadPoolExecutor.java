package con.ping.thread;

import java.util.concurrent.*;

/**
 * 自定义线程池处理器 implements ThreadPoolExecutor
 * 用于监控
 * @author zhangxiaoping
 *
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor{

	
	private static MyThreadPoolExecutor executor = new MyThreadPoolExecutor
			(Runtime.getRuntime().availableProcessors(), 32, 3L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024));
	

	private MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	
	/**
	 * executor()方法执行前
	 */
	@Override
	public void beforeExecute(Thread t, Runnable r) {
		//获取活动的线程数据/需要执行的任务数量
		System.out.println(t.getName()
				+ ", " + executor.getActiveCount()
				+ "，" + executor.getTaskCount()
		);
	 }
	
	/**
	 * 线程执行完毕后触发
	 */
	@Override
	public void afterExecute(Runnable r, Throwable t) { 
		System.currentTimeMillis();
	}


	@Override
	public <T> RunnableFuture<T> newTaskFor(Runnable var1, T var2){
		return new FutureTask(var1, var2);
	}


	@Override
	public <T> RunnableFuture<T> newTaskFor(Callable<T> var1){
		return new FutureTask<T>(var1);
	}


	/**
	 * 获取实例
	 * @return
	 */
	public static MyThreadPoolExecutor getInstance(){
		return executor;
	}
}


