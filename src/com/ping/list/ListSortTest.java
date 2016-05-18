package com.ping.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ping.enityt.Dog;

public class ListSortTest {
	
	public List<Dog> getlist1(){
		List<Dog> list = new ArrayList<Dog>();
		for(int i=0;i<100;i++){
			Dog dog = new Dog();
			dog.setAge(100+i);
			dog.setName("aaa");
			list.add(dog);
		}
		return list;
	}
	
	public List<Dog> getlist2(){
		List<Dog> list = new ArrayList<Dog>();
		for(int i=0;i<100;i++){
			Dog dog = new Dog();
			dog.setAge(101+i);
			dog.setName("bbb");
			list.add(dog);
		}
		return list;
	}
	
	/**
	 * 排序
	 * @return
	 */
	public List<Dog> compareDog(){
		List<Dog> list1 = getlist1();
		List<Dog> list2 = getlist2();
		list1.addAll(list2);
		//升序
		Collections.sort(list1, new Comparator<Dog>() {
			public int compare(Dog dog1, Dog dog2){
				return Integer.valueOf(dog1.getAge()).compareTo(Integer.valueOf(dog2.getAge()));
			}
		});
		//倒排序
		Collections.reverse(list1);
		return list1;
	}
	
	/***
	 * 去重
	 * @param list
	 * @return
	 */
	public List<Dog> removeRepeatEntity(List<Dog> list){
		Set<Integer> set = new HashSet<Integer>();
		List<Dog> newlist = new ArrayList<Dog>();
		if(list !=null && list.size() > 0){
			Iterator<Dog> iterator = list.iterator();
			
			while(iterator.hasNext()){
				Dog dog = iterator.next();
				if(set.add(dog.getAge())){
					newlist.add(dog);
				}
			}
		}
		return newlist;
	}
	
	/**
	 * 排序
	 */
	public void comparetorDog(){
		List<Dog> list1 = getlist1();
		List<Dog> list2 = getlist2();
		list1.addAll(list2);
		Collections.sort(list1, new DogEntityComparetor());
		for(Dog dog:list1){
			System.out.println(dog.getName() + " " + dog.getAge());
		}
		
	}
	
	
	public static void main(String[] args){
		ListSortTest listSortTest = new ListSortTest();
//		List<Dog>  list1 = listSortTest.compareDog();
//		for(Dog dog:list1){
//			System.out.println(dog.getAge() + " " + dog.getName());
//		}
		
		listSortTest.comparetorDog();
	
	}
}
