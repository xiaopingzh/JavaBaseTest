package com.ping.list;

import java.util.*;

public class MapConnectionTest {
	
	public Map<String,String> createMap(){
		Map<String,String> map = new HashMap<String,String>();
		
		for(int i=0;i<10;i++){
			map.put(i+"", i+"");
		}
		return map;
	}

	/**
	 * TreeMap模拟实现一致性Hash
	 *
	 */
	public void testTreeMap(){
		SortedMap<Integer,String> map = new TreeMap<Integer,String>();

		map.put(3, "a");
		map.put(7, "a");
		map.put(6, "a");
		map.put(1, "a");
		map.put(5, "a");
		map.put(9, "a");
		map.put(11, "a");
		map.put(13, "a");
		/* 定义的第一个节点 */
		System.out.println(map.firstKey());

		/* 大于Key值的节点*/
		SortedMap<Integer,String> sortedMap = map.tailMap(10);
		if(!sortedMap.isEmpty()){
			System.out.println(sortedMap.firstKey());
		}else{
			System.out.println(map.firstKey());
		}
	}
	
	
	public static void main(String[] args){
		Class<MapConnectionTest> classObject = (Class<MapConnectionTest>) new MapConnectionTest().getClass();

		System.out.println(UUID.randomUUID().toString());
		new MapConnectionTest().testTreeMap();
	}
}
