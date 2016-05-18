package com.ping.serializable;

import java.io.*;

/**
 * Title:应用学生类 Description:实现学生类实例的序列化与反序列化 Copyright: copyright(c) 2012
 * Filename: UseStudent.java
 *
 * @author Wang Luqing
 * @version 1.0
 */

public class UseStudent {
	
	public static void main(String[] args) {
		
		File file = new File("/Users/zhangxiaoping/java/student.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Student对象序列化过程
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Student st = new Student("Tom", 'M', 20, 3.6);
			oos.writeObject(st);
			oos.flush();
			oos.close();
			fos.close();

			// Student对象反序列化过程
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student st1 = (Student) ois.readObject();
			System.out.println("name = " + st1.getName());
			System.out.println("sex = " + st1.getSex());
			System.out.println("year = " + st1.getYear());
			System.out.println("gpa = " + st1.getGpa());
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
