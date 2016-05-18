package com.ping.classload;

import java.lang.reflect.Constructor;


public class BootstrapClassLoader {
	/**
	 * Bootstrap classLoader
	 */
	
	
	/**
	 * extentsion classloader
	 * 扩张类加载器
	 */
	public void test01(){
		System.out.println(System.getProperty("java.ext.dirs")); 
		ClassLoader extensionClassloader=ClassLoader.getSystemClassLoader().getParent(); 
	    System.out.println("the parent of extension classloader : "+extensionClassloader.getParent()); 
	}
	
	/**
	 * 系统类加载器
	 * system classloader
	 */
	public void systemClassLoader(){
		System.out.println(System.getProperty("java.class.path")); 
	}
	
	
	/**
	 * 反射获取Class的构造器并实例化
	 */
	public void constructorNewStance(){
		try {
			Constructor<BootstrapClassLoader> constractor = BootstrapClassLoader.class.getConstructor(BootstrapClassLoader.class);
			BootstrapClassLoader loader = (BootstrapClassLoader)constractor.newInstance(new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 类加载实例化对象
	 * Class.forname("") 会初始化static 变量
	 */
	public void testclassloader(){
		try {
			BootstrapClassLoader bootstrapClassLoader = (BootstrapClassLoader)BootstrapClassLoader.class.
					getClassLoader().loadClass("com.ping.classload.BootstrapClassLoader").newInstance();
		
			BootstrapClassLoader bootstrapClassLoade2 = (BootstrapClassLoader)Class.
					forName("com.ping.classload.BootstrapClassLoader").newInstance();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args){
		new BootstrapClassLoader().test01();
		
		System.out.println(ClassLoader.getSystemClassLoader());
	}
}
