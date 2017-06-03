package com.ping.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 注解 解析
 * @author zhangxiaoping
 *
 * Spring是如何使用注解机制完成自动装配？
 * 2015年6月4日 下午3:03:57
 */
public class TestAnnotionOperator {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Testname testname = new Testname();
		Method[] methods = Testname.class.getDeclaredMethods();
	
		for(Method method:methods){
			TestAnnotation testAnnotatation = method.getAnnotation(TestAnnotation.class);
			/**
			 * 如果是有注解
			 */
			if(testAnnotatation!=null){
				method.invoke(testname, testAnnotatation.name());
			}else{
				method.invoke(testname, "no annotation");
			}
		}
		//aaa
	}
}
