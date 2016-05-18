package com.ping.list;

import java.util.Comparator;

import com.ping.enityt.Dog;

public class DogEntityComparetor implements Comparator<Dog>{
	
	/**
	 * 获取的List是根据age属性由小到大的顺序
	 * 如果要获取由大到小则是：
	 * 与之相反
	 */
	@Override
	public int compare(Dog o1, Dog o2) {
		if(o1.getAge() > o2.getAge()){
			return 1;
		}else if(o1.getAge() < o2.getAge()){
			return -1;
		}else{
			return 0;
		}
	}

}
