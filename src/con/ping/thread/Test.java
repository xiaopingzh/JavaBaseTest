package con.ping.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author zhangxiaoping
 *
 */
public class Test {
	
	private volatile static Test test;
	private ThreadPoolExecutor threadPoolExecutor;
	private static Object lock;
	
	private Test(){
		
	}
	
	
	private static Test getInstance(int maximumPoolSize,int corePoolSize){
		if(test == null ){
			synchronized(lock){
				if(test == null){
					test = new Test();
					test.threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 3L, 
							TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1024), Executors.defaultThreadFactory());
				}
			}
		}
		return test;
	}
	
	
	public final static Test getInstance(){
		return getInstance(100, 32);
	}
	
	/**
	 * 执行
	 * @param commend
	 */
	public void executor(Runnable commend){
		this.threadPoolExecutor.execute(commend);
	}
	
	/**
	 * shutdown
	 */
	public  void shutdown(){
		threadPoolExecutor.shutdown();
	}
	
	
	
	/**
	 * 执行并返回结果
	 * @param task
	 * @return
	 */
	public <T> Future<T> submit(Callable<T> task){
		return threadPoolExecutor.submit(task);
	}
}
