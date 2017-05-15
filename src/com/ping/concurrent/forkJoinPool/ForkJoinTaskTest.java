package com.ping.concurrent.forkJoinPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join框架
 * 将大人物分隔成多个小任务，最后汇总每个小任务结果后获取得到大任务结果的框架
 * 可以理解为分布式计算的一种
 * 从1~100累加求和
 * @author
 *
 * 2016年3月29日 上午10:39:13
 */
public class ForkJoinTaskTest extends RecursiveTask<Integer>{

	private static final long serialVersionUID = 1L;
	//阈值，即每个线程计算的区间<=10
	private static final int THRESHLOD = 10;
	private int start;
	private int end;
	//创建ForkJoinPool
	private static ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

	public ForkJoinTaskTest(int start,int end){
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end-start) <= THRESHLOD;
		if(canCompute){
			for(int i=start;i<=end;i++){
				sum +=i;
			}
		}else{
			int middle = (start + end) >> 1;
			//创建子任务
			ForkJoinTaskTest leftJoin = new ForkJoinTaskTest(start, middle);
			ForkJoinTaskTest rightJoin = new ForkJoinTaskTest(middle+1, end);
			//开始执行任务
			leftJoin.fork();
			rightJoin.fork();
			//获取结果
			int leftResult = leftJoin.join();
			int rightResult = rightJoin.join();
			//合并子任务
			sum = leftResult + rightResult;
		}
		return sum;
	}


	public static void main(String[] args){
		//创建一个计算任务 1~100
		ForkJoinTaskTest forkJoinPoolTest = new ForkJoinTaskTest(1, 100);
		//执行任务
		Future<Integer> future =  forkJoinPool.submit(forkJoinPoolTest);
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		forkJoinPool.shutdown();
	}
}
