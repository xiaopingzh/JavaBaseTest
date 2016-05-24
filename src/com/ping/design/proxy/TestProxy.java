package com.ping.design.proxy;

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
		//设置该系统属性为了JVM将生成的代理类写入到文件中，com.sun.proxy.$Proxy0
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		BookProxy bookProxy = new BookProxy();
		BookFacade bookFacade =  (BookFacade)bookProxy.getProxy(new BookFacadeImpl());
		bookFacade.addBook();
	}
}
