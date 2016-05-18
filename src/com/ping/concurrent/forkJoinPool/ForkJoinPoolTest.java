package com.ping.concurrent.forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool的使用
 * @author 
 *
 * 2016年4月6日 上午11:32:32
 */
public class ForkJoinPoolTest {
	
	
	private static int threadNum = Runtime.getRuntime().availableProcessors();
	
	private static ForkJoinPool forkJoinPool = new ForkJoinPool(threadNum);
	
	
	
	public void testPool(){
		forkJoinPool.submit(new RecursiveTask<Integer>() {

			@Override
			protected Integer compute() {
				return null;
			}
			
			
		});
		
		
		
	}
	
	public static void main(String[] args){
		
	}

}
