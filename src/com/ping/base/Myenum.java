package com.ping.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum Myenum {
	
	
	A(10,"a");
	
	private int num;
	private String type;
	private Myenum(int num,String type){
		this.num = num;
		this.type = type;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public static void main(String[] args){
		Myenum.A.setNum(101);
		System.out.println(Myenum.A.num);
		
		
		Constructor<?> constructor =  Myenum.class.getConstructors()[0];
		constructor.setAccessible(true);
		
		try {
			constructor.newInstance(11,"bb");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
