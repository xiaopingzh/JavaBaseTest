package com.ping.comparable;

import java.util.Comparator;

public class ComparatorTest implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return 0;
	}
	
	
	/**
	 * 重写equals
	 */
	@Override
	public boolean equals(Object o){
		return false;
	}
	
	/**
	 * 重写equals方法则要重写hashCode方法用于保证equals后的对象其hashCode值一致
	 */
	@Override
	public int hashCode(){
		return 0;
	}
}
