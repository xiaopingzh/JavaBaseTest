package con.ping.thread;

import java.util.List;
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
	
	
	private  static Object object;
	private static volatile Test testInstance;
	private ThreadPoolExecutor threadPoolExecutor;
	
	private Test(){
		
	}
	
	private static Test getTestInstance(){
		if(testInstance == null){
			synchronized(object){
				if(testInstance == null){
					testInstance = new Test();
					testInstance.threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 1000, 3L, TimeUnit.MILLISECONDS,
							new LinkedBlockingDeque<Runnable>(100),Executors.defaultThreadFactory());
					testInstance.threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
				}
			}
		}
		return testInstance;
	}
	
	/**
	 * 
	 * @return
	 */
	public Test getInstance(){
		return getTestInstance();
	}
	
	/**
	 * 
	 * @param task
	 */
	public void executor(Runnable task){
		threadPoolExecutor.execute(task);
	}
	
	/**
	 * 带返回参数的提交任务
	 * @param task
	 * @return
	 */
	public <T> Future<T> submit(Callable<T> task){
		return threadPoolExecutor.submit(task);
	}
	
	
	/**
	 * 
	 */
	public void shutdown(){
		threadPoolExecutor.shutdown();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Runnable> shutdownNow(){
		return threadPoolExecutor.shutdownNow();
	}
}
