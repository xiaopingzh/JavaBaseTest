package com.ping.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {
	
	public  Object getProxyObject(){
		InvocationHandler handler = new BookProxy();
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		ClassLoader classLoader = this.getClass().getClassLoader();
		return Proxy.newProxyInstance(classLoader, new Class[]{BookFacade.class}, handler);
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public  static void main(String[] args){
		BookProxy bookProxy = new BookProxy();
		BookFacade bookFacade =  (BookFacade)bookProxy.getProxy(new BookFacadeImpl());
		bookFacade.addBook();
	}
}
