package com.ping.thread;

public class ThreadRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
	}
}
