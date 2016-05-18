package com.ping.classload;

/**
 * classLoader 作为获取资源
 * @author zhangxiaoping
 *
 * 2015年8月6日 下午11:28:36
 */
public class ClassLoaderPath {
	
	
	public static void main(String[] args){
		
		System.out.println(String.class.getClassLoader().toString());
		System.out.println(ClassLoaderPath.class.getClassLoader().getSystemClassLoader().getParent().getParent().toString());
		
		
//		String classpath = ClassLoaderPath.class.getClassLoader().getResource("com/ping/classload/ClassLoaderPath.class").getPath();
		/**
		 * /Users/a58/java/workspace/JustForFun/bin/
		 */
//		String classpath = ClassLoaderPath.class.getClassLoader().getResource("").getPath();
//		System.out.println(classpath);
//		
//		/**
//		 * 类对应的包路径
//		 */
//		System.out.println(ClassLoaderPath.class.getResource("").getPath());
	}
}
