package com.ping.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {
	
	private static ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	/**
	 * 使用Future
	 * 1）Future与实现Callable的线程配合使用
	 * 2）获取返回结果使用executor.submit方法
	 * 3) 实现Callable的线程不能使用executor.executor()方法
	 * @throws Exception
	 */
	public void testFuture() throws Exception{
		for(int i=0;i<5;i++){
			Future<Integer> future =  executorService.submit(new Task());
			System.out.println(future.get());
		}
	}
	
	/**
	 * 使用FutureTask
	 * 1) FutureTask继承Runnable、Future，因此可以执行executor.submit与executor方法
	 *
	 * @throws Exception
	 */
	public void testFutureTask() throws Exception{
		List<FutureTask<Integer>> list = new ArrayList<FutureTask<Integer>>();
		for(int i=0;i<5;i++){
			Task task = new Task();
			FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
			list.add(futureTask);
			executorService.submit(futureTask);
		}
		//遍历List，获取结果
		int sum = 0;
		for(int i=0;i<list.size();i++){
			FutureTask<Integer> futureTask = list.get(i);
			sum =+ futureTask.get();
		}
		System.out.println(sum);
	}
	
	/**
	 * 使用继承FutureTask的线程
	 * 1）可以使用FutureTask的protected方法
	 *
	 *
	 * @throws Exception
	 */
	public void testFutureDone() throws Exception{
		for(int i=0;i<5;i++){
			Task task = new Task();
			MyFutureTask futureTask = new MyFutureTask(task);
			executorService.submit(futureTask);
			System.out.println(futureTask.get());
		}
	}
	
	
	public static void main(String[] args){
		try{
			new FutureTest().testFutureDone();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//线程执行完毕后将线程池关闭
			executorService.shutdown();
		}
	}
}

/**
 * 创建Task
 */
class Task implements Callable<Integer>{
	
	@Override
	public Integer call(){
		return 10;
	}
}

class MyFutureTask extends FutureTask<Integer>{

	public MyFutureTask(Callable<Integer> callable) {
		super(callable);
	}
	
	/**
	 * 线程执行完毕后的回调函数
	 */
	@Override
	public void done(){
		try {
			System.out.println(get().intValue() + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
