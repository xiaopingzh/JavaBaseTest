package com.ping.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.*;
import java.lang.reflect.Proxy;
import java.util.Comparator;
import java.util.concurrent.Executors;

/**
 * 使用 LinkedBlockingQueue实现Product And Consumer
 * 
 * @author zhangxiaoping
 *
 *         2015年5月30日 下午5:45:26
 */
public class LinkedBlockingQueueTest {
	private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(
			10);
	private int MAX = 10;

	public LinkedBlockingQueueTest() {
	}

	public void start() {
		new Producer().start();
		new Consumer().start();
	}

	public static void main(String[] args) throws Exception {
		LinkedBlockingQueueTest s3 = new LinkedBlockingQueueTest();
		s3.start();
	}

	class Producer extends Thread {
		public void run() {
			while (true) {
				try {
					if (queue.size() == MAX) {
						System.out.println("warning: it's full!");
					}
					Object o = new Object();
					queue.put(o);
					System.out.println("Producer: " + o.hashCode());
				} catch (InterruptedException e) {
					System.out.println("producer is interrupted!");
				}
			}
		}
	}

	class Consumer extends Thread {
		public void run() {
			while (true) {
				try {
					if (queue.size() == 0)
						System.out.println("warning: it's empty!");
					Object o = queue.take();
					System.out.println("Consumer: " + o);
				} catch (InterruptedException e) {
					System.out.println("producer is interrupted!");
				}
			}
		}
	}
}
