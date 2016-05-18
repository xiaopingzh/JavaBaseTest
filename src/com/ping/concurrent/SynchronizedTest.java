package com.ping.concurrent;

public class SynchronizedTest {
	
	//方法method1、Method2锁住的都是SynchronizedTest.class实例
	public static synchronized void methor1(){}
	public void method2(){
		synchronized (SynchronizedTest.class) {}
	}
	//锁住的是myObject对象，但是该对象为static类型，实际上也是锁SynchronizedTest.class实例
	private static Object myObject = new Object();
	public void method06(){
		synchronized (myObject) {}
	}
	
	
	//锁住的都是对象的实例
	public synchronized void method3(){}
	//同步代码块
	public void method4(){
		synchronized(this){
		}
	}
	//锁住的是Object object这个对象，与method3/method4功能一致
	private Object object = new Object();
	public void method05(){
		synchronized(object){
		}
	}
}
