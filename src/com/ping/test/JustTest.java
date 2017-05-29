package com.ping.test;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Comparator;

import java.lang.Runtime;
import com.ping.enityt.Dog;


public class JustTest<T> implements Comparator<T>{
	
	public static void test(){
		Method[] methods  = JustTest.class.getDeclaredMethods();
		int length = Array.getLength(methods);
		for(Method method:methods){
			System.out.println(method.getName());
		}
	}
	
	
	public void testClone() throws CloneNotSupportedException{
		Dog dog1 = new Dog();
		Dog dog2 = dog1;
		System.out.println(dog1.hashCode() + " " + dog2.hashCode());
		
		Dog dog3 = (Dog)dog1.clone();
		System.out.println(dog3.getName() == dog1.getName());
		
	}
	
	public static void main(String[] args){
//		try {
//			new JustTest<>().testClone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		int num = 20195;
//		System.out.println((char)num );
//
//		int b = 97;
//		byte ss = (byte)b;
//		System.out.println(ss);
//
//
//		byte bb = 'a';
//		System.out.println((int)bb);
	}
	
	
	
	/**
	 * 不Override equals(Object obj)
	 */
	@Override
	public int compare(T o1, T o2) {
		return 0;
	}

}
