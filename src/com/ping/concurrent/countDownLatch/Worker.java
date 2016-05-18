package com.ping.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
	
	
	private CountDownLatch countDownLatch;
	
	public Worker(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		System.out.println(Thread.currentThread().getName());
		this.countDownLatch.countDown();
	}
}
