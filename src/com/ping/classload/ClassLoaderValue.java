package com.ping.classload;

/**
 *  ClassLoader加载时初始化值
 * @author 
 *
 * 2016年3月28日 下午1:51:11
 */
public class ClassLoaderValue {
	
	private static int a = getvalue();
	
	static int getvalue(){
		return b;
	}
	
	private static int b = 5;
	
	public static void main(String[] args){
		//a==0 b==5;
		System.out.println(ClassLoaderValue.a + " " + ClassLoaderValue.b);
		//使用类实例值也是0
		System.out.println(new ClassLoaderValue().a);
	}
}
