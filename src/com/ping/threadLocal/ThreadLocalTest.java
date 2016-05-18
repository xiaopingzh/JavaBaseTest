package com.ping.threadLocal;


/**
 * ThreadLocal
 * @author 
 *
 * 2016年4月17日 下午2:18:29
 */
public class ThreadLocalTest implements Runnable{
	
	//为主线程Main的ThreadLocal
	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	private static final String a ="10";
	
	@Override
	public void run(){
		System.out.println(threadLocal.get());
		threadLocal.set("aa");
		//替换value="aa"
		threadLocal.set(Thread.currentThread().getName());
		System.out.println(threadLocal.get());
	}
	
	public static void main(String[] args){
		threadLocal.set(a);
		for(int i=0;i<2;i++){
			new Thread(new ThreadLocalTest()).start();
		}
		System.out.println(threadLocal.get());
	}
}

