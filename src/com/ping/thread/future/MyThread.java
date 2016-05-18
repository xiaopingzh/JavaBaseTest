package com.ping.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ConcurrentHashMap;



public class MyThread extends FutureTask<Integer>{

	public MyThread(Callable<Integer> callable) {
		super(callable);
	}
	
	
}
