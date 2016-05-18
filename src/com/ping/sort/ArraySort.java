package com.ping.sort;

/**
 * Comparator接口的使用
 * Comparator
 * equals
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.ping.enityt.Dog;

public class ArraySort implements Comparator<Dog>{
	public static void main(String[] args){
		ArraySort sort = new ArraySort();
		sort.test02();
	}
	
	public void test01(){
		String[] str = {"y","n","f","s"};
		Arrays.sort(str,Collections.reverseOrder());
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}
	
	//排序
	public void test02(){
//		Dog[] dogs1 = {new Dog("a",16),new Dog("b",11),new Dog("c",12),new Dog("a",12)};
//		//Dog[] dogs2 = {new Dog("a",1),new Dog("b",11),new Dog("c",12)};
//		Arrays.sort(dogs1, new ArraySort());
//		for(int i=0;i<dogs1.length;i++){
//			System.out.println(dogs1[i].getAge() + "::" +dogs1[i].getName());
//		}
	}

	@Override
	public int compare(Dog o1, Dog o2) {
		//实现倒排序
		if(o1.getAge() - o2.getAge() == 0){
			if(o1.getName().compareTo(o2.getName()) > 0){
				return -1;
			}else{
				return o2.getName().compareTo(o1.getName());
			}
		}else{
			int res = o1.getAge()-o2.getAge();
			if(res >0){
				return -1;
			}else{
				return 1;
			}
		}
		//正排序
//		if(o1.getAge()-o2.getAge()==0){
//			return o1.getName().compareTo(o2.getName());
//		}else{
//			return o1.getAge()-o2.getAge();
//		}
	}
	
	@Override
	public boolean equals(Object ob){
		return false;
	}
}
