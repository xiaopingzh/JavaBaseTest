package com.ping.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author 
 *
 * 2015年10月29日 上午12:45:02
 */
public class BookProxy implements InvocationHandler{
	
	private Object target;
	
	/**
	 * 根据接口创建动态代理类
	 * @param type
	 * @return
	 */
	public Object getProxy(Class<?> type){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { type }, this);
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public Object getProxy(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);
	}
	
	
	/**
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		/**
		 * Method.invoke  
		 * @param target 执行对象，如果执行的是类的静态方法，则单元参数为null
		 * @param args 执行方法的单元参数
		 */
		Object result = method.invoke(target, args);
		return result;
	}
}
