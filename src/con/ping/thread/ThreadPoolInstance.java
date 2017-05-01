package con.ping.thread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用volatile延迟加载创建单例模式
 * 创建线程池 ThreadPoolExecutor
 * @author 
 *
 * 2016年1月16日 下午3:24:03
 */
public class ThreadPoolInstance {

	/**
	 * 使用volatile是为了防止指令重排，具体是用于threadPoolInstance = new ThreadPoolInstance()时
	 * 即初始化对象与执行引用地址这两步
	 */
	private volatile static ThreadPoolInstance threadPoolInstance;
	private static Object lock = new Object();
	private ThreadPoolExecutor executor;
	/**
	 * 构造器私有化，使调用方只能通过getInstance()方法获取唯一实例
	 */
	private ThreadPoolInstance(){
	}
	
	
	public static ThreadPoolInstance getInstance(int maxPoolSize,int queenSize){
		if(threadPoolInstance == null){
			synchronized(lock){
				if(threadPoolInstance == null){
					threadPoolInstance = new ThreadPoolInstance();
					threadPoolInstance.executor = new ThreadPoolExecutor(
							Runtime.getRuntime().availableProcessors(),
							maxPoolSize,
							3L, TimeUnit.MILLISECONDS,
							new LinkedBlockingQueue<Runnable>(queenSize),
							Executors.defaultThreadFactory());
					threadPoolInstance.executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
				}
			}
		}
		return threadPoolInstance;
	}
	
	
	/**
	 * 获取，将线程池的对象不直接暴露给第三方，仅仅提供方法
	 * @return
	 */
	public final static ThreadPoolInstance getInstance(){
		return getInstance(32,1024);
	}
	
	
	/**
	 * 加入线程
	 * @param command
	 */
	public void execute(Runnable command){
		executor.execute(command);
	}



	/**
	 * 不再接受新任务，等待线程池中的和队列中的任务执行完毕
	 */
	public void shutdown(){
		executor.shutdown();
	}
	
	/**
	 * 不再执行BlockQueue中的任务，并尝试终止线程池中的任务
	 * 返回BlockQueue中的未执行任务
	 * @return
	 */
	public List<Runnable> shutdownNow(){
		List<Runnable> list = executor.shutdownNow();
		return list;
	}
	
	/**
	 * 提交并放回
	 * @param task
	 */
	public <T> Future<T> submit(Callable<T> task){
		return executor.submit(task);
	}
}
