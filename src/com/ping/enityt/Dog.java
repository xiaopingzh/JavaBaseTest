package com.ping.enityt;


public class Dog{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean equals(Dog dog1,Dog dog2){
		return dog1.getAge() == dog2.getAge();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return (Dog)super.clone();
	}
	
}	
