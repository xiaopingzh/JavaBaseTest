package com.ping.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 测试Callable、FutureTask
 */
public class FutureTaskTest {
	
	private static ExecutorService executoService = Executors.newFixedThreadPool(5);
	
	public void test01(){
		for(int i=0;i<5;i++){
			MyTask mytask = new MyTask();
			FutureTask<String> myFuture = new FutureTask<String>(mytask);
			executoService.submit(myFuture);
			try {
				//调用线程阻塞
				System.out.println(myFuture.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args){
		new FutureTaskTest().test01();
		executoService.shutdown();
	}
}

/**
 * 
 * @author 
 *
 * 2016年3月9日 下午11:10:12
 */
class MyTask implements Callable<String>{
	
	@Override
	public String call(){
		return Thread.currentThread().getName();
	}
}
