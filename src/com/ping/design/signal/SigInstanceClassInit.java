package com.ping.design.signal;


/**
 * 使用类加载延迟加载
 * @author 
 *
 * 2016年2月28日 下午4:03:33
 */
public class SigInstanceClassInit {
	
	private static class SignalHolder{
		public static  SigInstanceClassInit signalInstance = new SigInstanceClassInit();
	}
	
	public static SigInstanceClassInit getInstance(){
		return SignalHolder.signalInstance;
	}
	
	private SigInstanceClassInit(){
		
	}
}
