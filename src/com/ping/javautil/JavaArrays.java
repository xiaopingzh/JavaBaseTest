package com.ping.javautil;

import java.util.HashSet;
import java.util.Set;

public class JavaArrays {
	
	public void testArrays(){
		String myskillids = "1|2|3|4|5|6";
		String defaultids = "3|4|5|2|1|7|8|6";
		String[] defautidsArray = defaultids.split("|");
		StringBuffer otherCateIds = new StringBuffer();
		int length = defautidsArray.length;
		for(int i=0;i<length;i++){
			if(!"|".equals(defautidsArray[i]) && !myskillids.contains("|" + defautidsArray[i]) && !myskillids.contains(defautidsArray[i] + "|")){
				otherCateIds.append(defautidsArray[i] + "|");
			}
		}
		String cateids = otherCateIds.toString();
		System.out.println(cateids.substring(0, cateids.length()-1));
		
		
		
	}
	
	
	public void test01(){
		Test test = new Test();
		test.setAge((short)0);
		
		System.out.println(test.getAge());
	}
	
	
	public static void main(String[] args){
		new JavaArrays().test01();
	}
	
	public class Test{
		private short age;

		public short getAge() {
			return age;
		}

		public void setAge(short age) {
			this.age = age;
		}
	}
	
}


