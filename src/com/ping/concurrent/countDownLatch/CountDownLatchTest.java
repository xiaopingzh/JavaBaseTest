package com.ping.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;


/**
 * java.util.concurrent.CountDownLatch
 * 多线程
 * @author zhangxiaoping
 *
 */
public class CountDownLatchTest {
	
	private final static int count = 10;
	
	private static ExecutorService executorService = Executors.newFixedThreadPool(count);
	
	/**
	 * 多线程完成计数
	 * @throws Exception
	 */
	public void test01() throws Exception{
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		final AtomicLong atomicLong = new AtomicLong(0);
		for(int i=0;i<count;i++){
			//创建线程并执行
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					atomicLong.addAndGet(1);
					countDownLatch.countDown();
				}
			});
		}
		//主线程等待多个Work线程执行完毕后再执行
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName());
		System.out.println(atomicLong.get());
	}
	
	
	
	public static void main(String[] args) {
		
		try {
			new CountDownLatchTest().test01();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			executorService.shutdown();
		}
		
//		CountDownLatch countDownLatch = new CountDownLatch(count);
//		for(int i=0;i<count;i++){
//			executorService.execute(new Worker(countDownLatch));
//		}
//		
//		//主线程
//		try {
//			countDownLatch.await(100L, TimeUnit.MICROSECONDS);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() +  " is end");
//		executorService.shutdown();
	}
	
}
