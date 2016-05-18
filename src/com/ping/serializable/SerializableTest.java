package com.ping.serializable;

import java.io.Serializable;

/**
 * 序列化
 * @author zhangxiaoping
 *
 */
public class SerializableTest implements Serializable{

	 //当类改变后也能正确反序列化出该对象，如果方序列化中的UID不同，则是不能进行反序列化的
	private static final long serialVersionUID = 1L;

	
	private String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args){
		System.out.println("hello world");
	}
}
