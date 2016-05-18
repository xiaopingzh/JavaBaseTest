package com.ping.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用Future/callable接口来实现获取值
 * @author 
 *
 * 2016年2月29日 下午1:27:46
 */
public class ThreadsTest{
	
	private static ExecutorService executorService =  Executors.newCachedThreadPool();
	
	public void testThreadRunnable() throws Exception{
		Future<String> future = (Future<String>) executorService.submit(new ThreadRunnable());
		//返回NULL
		System.out.println(future.get());
	}
	
	
	public void testCallable() throws Exception{
		for(int i=0;i<5;i++){
			//实现接口 implements callable
			ThreadTets task = new ThreadTets();
			Future<Integer> future =  executorService.submit(task);
			System.out.println(future.get());
		}
	}
	
	
	public static void main(String[] args){ 
		ThreadsTest test = new ThreadsTest();
		try{
			test.testThreadRunnable();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭线程池
			executorService.shutdown();
		}
		
		
	}
}



