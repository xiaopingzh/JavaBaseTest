package con.ping.thread;

import java.util.concurrent.ThreadFactory;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义ThreadFactory
 * @author 
 *
 * 2016年2月17日 上午10:30:27
 */
public class MyThreadFactory implements ThreadFactory{
	
	/**
	 * 创建线程
	 */
	@Override
	public Thread newThread(Runnable r) {
		//		return new Thread();
		return null;
	}

}
