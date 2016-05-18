package com.ping.base;

import java.util.HashMap;
import java.util.Map;

public class StringTestSon implements Runnable{

	
	
	/**
	 * 
	 */
	public  static void updateMap(){
		System.out.println(StringTestSon.class.getName());
	}
	
	@Override
	public void run() {
		System.out.println(this.getClass().getName());
	}

	public static void main(String[] args){
		new Thread(new StringTestSon()).start();
	}
}
