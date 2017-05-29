package com.ping.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantLock
 * @author zhangxiaoping
 *
 * 2015年5月17日 下午4:40:47
 */
public class LockTest {
	
	private final static ReentrantLock reetranLock =  new ReentrantLock(true);
	private Condition codition = reetranLock.newCondition();


	private final static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

	public void testReetranLock(){
		try {
			reetranLock.tryLock();
			//释放锁
			codition.await();
			//
			codition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			reetranLock.unlock();
		}
	}

	/**
	 *
	 */
	public void testLock(){
		for(int i=0;i<10;i++){
			Thread thread = new Thread(new MyLockTask());
			thread.start();
		}
	}



	public static void main(String[] args){
		new LockTest().testLock();
	}

	class MyLockTask implements Runnable{
		@Override
		public void run() {
			try{
				reetranLock.tryLock(1000L,TimeUnit.MILLISECONDS);
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(10000L);
				System.out.println(Thread.currentThread().getName() + "::::");
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				reetranLock.unlock();
			}
		}
	}
}
