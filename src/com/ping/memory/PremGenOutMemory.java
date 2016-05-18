//package com.ping.memory;
//
//import java.lang.reflect.Method;
//import net.sf.cglib.proxy.Enhancer;
//
//
//public class PremGenOutMemory {
//	
//	public static void main(String[] args){
//		while (true) {
//	        Enhancer enhancer = new Enhancer();
//	        enhancer.setSuperclass(OOMObject.class);
//	        enhancer.setUseCache(false);
//	        enhancer.setCallback(new MethodInterceptor() {
//	            public Object intercept(Object obj, Method method,
//	                    Object[] args, MethodProxy proxy) throws Throwable {
//	                return proxy.invokeSuper(obj, args);
//	            }
//	        });
//	        enhancer.create();
//	    }
//	}
//	
//	
//	static class OOMObject {
//	}
//	
//	
//}
