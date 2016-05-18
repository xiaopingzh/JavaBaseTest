package com.ping.Collection;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {
	
	public void testLinkedBlockingQueue(){
		int queueSize = 1024;
		//置顶大小，默认为Integer.MAX_VALUE
		LinkedBlockingQueue<String> myQueue = new LinkedBlockingQueue<String>(queueSize);
		try {
			myQueue.add("a");
			myQueue.offer("a");
			myQueue.offer("b");
			
			//阻塞方法
			myQueue.put("b");//阻塞方法，如果Queue中有空闲则插入，无则阻塞该线程
			myQueue.take();//阻塞方法，取走排在首位的元素
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("is interrupt");
		}
		System.out.println(myQueue.size());
		System.out.println("hello world");
	}
	
	
	/**
	 *  ConcurrentLinkedQueue 非阻塞的线程安全Queue
	 */
	public void testConcurrentLinkedQueue(){
		ConcurrentLinkedQueue<String> myqueue = new ConcurrentLinkedQueue<String>();
		for(int i=0;i<10;i++){
			myqueue.offer(i+"");
		}
		System.out.println(myqueue.size());
	
	}
	
	public static void main(String[] args){
		new QueueTest().testConcurrentLinkedQueue();
	}
	
}
