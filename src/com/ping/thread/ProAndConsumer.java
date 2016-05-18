package com.ping.thread;

/**
 * 
 * @author zhangxiaoping
 *
 * 2015年5月30日 下午2:58:35
 */
public class ProAndConsumer {
	
	
	public void start() throws InterruptedException{
		new Product().start();
		Thread.sleep(100);
		new Consumer().start();
	}
	
	
	public static void main(String[] args){
		try {
			new ProAndConsumer().start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * 
 * @author zhangxiaoping
 *
 * 2015年5月30日 下午2:59:31
 */
class Product extends Thread{
	
	private int sum = 0;
	
	@Override
	public void run() {
		
		while(true && sum < 5){
			synchronized(ThreadUtils.mylist){
				while(ThreadUtils.mylist.size() == ThreadUtils.num){
					try {
						System.out.println("product: is  full");
						ThreadUtils.mylist.wait(100);
						 sum++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Object object = new Object();
				if(ThreadUtils.mylist.add(object)){
					System.out.println("product size:" + ThreadUtils.mylist.size());
					ThreadUtils.mylist.notify();
				}
			}
			
		}
	}
}

/**
 * 
 * @author zhangxiaoping
 *
 * 2015年5月30日 下午2:59:36
 */
class Consumer extends Thread{
	@Override
	public void run(){
		while(true){
			synchronized(ThreadUtils.mylist){
				while(ThreadUtils.mylist.size() == 0){
					try {
						System.out.println("consumer: is empty");
						ThreadUtils.mylist.wait(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				ThreadUtils.mylist.removeLast();
				System.out.println("consumer size:" + ThreadUtils.mylist.size());
				ThreadUtils.mylist.notify();
			}
		}
	}
}
