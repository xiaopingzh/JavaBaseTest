package com.ping.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个注解
 * @author zhangxiaoping
 *
 * 2015年6月4日 下午2:11:15
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
	/**
	 * default 默认值
	 * @return
	 */
	String name() default "ping";
	
	int age() default 10;
}
