package com.ping.annotation;

public class Testname {

	@TestAnnotation(name="hello world",age=20)
	public void sayname(String name){
		System.out.println(name);
	}
	
	public void saynamesayram(String name){
		System.out.println(name);
	}
}
