package com.ping.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义classloader
 * 
 * @author liuxiaochen
 *
 */
public class MyClassLoader extends ClassLoader {
	String path = "/Users/a58/java/workspace/JustForFun/bin/";
	String name;
	String fileType = ".class";

	public MyClassLoader(String name) {
		super();
		this.name = name;
	}

	public MyClassLoader(ClassLoader classloader, String name) {
		//显示指定该类加载器的父加载器
		super(classloader);
		this.name = name;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = loadClassData(name);
		return defineClass(name, data, 0, data.length);
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	/**
	 * 获取.class文件的字节数组
	 * @param name
	 * @return
	 */
	private byte[] loadClassData(String name) {
		byte[] data = null;
		InputStream in = null;
		ByteArrayOutputStream baos = null;
		try {
			this.name = this.name.replace(".", "\\");
			in = new FileInputStream(new File(path + name + fileType));

			baos = new ByteArrayOutputStream();
			int cnt = 0;
			while (-1 != (cnt = in.read())) {
				baos.write(cnt);
			}
			data = baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return data;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		//loader1的父加载器为系统类加载器
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/a58/java/workspace/JustForFun/bin/");
        
        
        
        
        //loader2的父加载器为loader1
        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        loader2.setPath("/Users/a58/java/workspace/JustForFun/bin/");
        
        Class clazz = loader2.loadClass("com.ping.classload.Sample");
        System.out.println(clazz.getClassLoader());
		
        
//        //loader3的父加载器为根类加载器
//        MyClassLoader loader3 = new MyClassLoader(null, "loader3");
//        loader3.setPath("/Users/a58/java/workspace/JustForFun/bin/com/ping/classload/");
       
		
//		MyClassLoader loader1 = new MyClassLoader("loader1");
//		loader1.setPath("d:\\myapp\\loader1lib\\");
//
//		Class<?> clazz = loader1.loadClass("");
//		
//		loader1 = null;
//		
//		MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
//		loader2.setPath("d:\\myapp\\loader2lib\\");
//
//		MyClassLoader loader3 = new MyClassLoader(null, "loader3");
//		loader3.setPath("d:\\myapp\\syslib\\");
//
//		System.out.println("-------------");
//		test(loader1);
//		System.out.println("-------------");
//		test(loader2);
//		System.out.println("-------------");
		// test(loader3) ;
        
	}

	public void classLoaderTest(){
		ClassLoader classLoader = MyClassLoader.class.getClassLoader();
		System.out.println(classLoader);
		
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
	}
	
	
	public static void test(ClassLoader classloder)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Class<?> classzz = classloder.loadClass("Sample");
		Object instance = classzz.newInstance();
	}
}
