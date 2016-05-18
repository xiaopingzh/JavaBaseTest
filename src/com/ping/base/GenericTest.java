package com.ping.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhangxiaoping
 *
 * 2015年5月16日 上午11:51:51
 * @param <T>
 */
public class GenericTest<T> {
	
	private Object[] objects = new Object[]{1,"abc"};
	
	@SuppressWarnings("unchecked")
	public void copyArrays(){
		List<T> list = new ArrayList<T>();
		for(int i=0;i<objects.length;i++){
			list.add((T) objects[i]);
		}
		System.out.println(list.size());
	}
	
	@SuppressWarnings("hiding")
	public <T> void paramsGeneric(T t){
		System.out.println(t);
	}
	
	public void printlist(List<?> list){
		System.out.println(list.size());
	}
	
	public void delete(T entity){
		
	}
	
	public static void main(String[] args){
//		GenericTest<?> genericTest = new GenericTest<Object>();
////		genericTest.copyArrays();
//		genericTest.paramsGeneric("ss");
//		genericTest.printlist(new ArrayList<Integer>());
		
		
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
	
}
