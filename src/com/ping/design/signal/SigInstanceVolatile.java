package com.ping.design.signal;

import java.io.Serializable;

/**
 * 使用volatile延迟加载初始化单例模式
 * @author 
 *
 * 2016年2月27日 下午5:06:44
 */
public class SigInstanceVolatile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//使用volatile、Synchronized双重校验延迟加载
	private static volatile SigInstanceVolatile signalMain;
	private static Object lock = new Object();
	private SigInstanceVolatile(){
		
	}
	
	
	public static SigInstanceVolatile getInstance(){
		
		if(signalMain == null){
			synchronized (lock) {
				if(signalMain == null){
					signalMain = new SigInstanceVolatile();
				}
				
			}
		}
		return signalMain;
	}
	
	/**
	 * 为了防止序列化
	 * @return
	 */
	private Object readResolve(){
		return signalMain;
	}
}
