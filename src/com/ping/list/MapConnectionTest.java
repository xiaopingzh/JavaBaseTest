package com.ping.list;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapConnectionTest {
	
	public Map<String,String> createMap(){
		Map<String,String> map = new HashMap<String,String>();
		
		for(int i=0;i<10;i++){
			map.put(i+"", i+"");
		}
		return map;
	}
	
	
	public void testTreeMap(){
		SortedMap<Integer,String> map = new TreeMap<Integer,String>();
		map.put(1, "a");
		map.put(3, "a");
		map.put(5, "a");
		map.put(6, "a");
		map.put(7, "a");
		map.put(9, "a");
		map.put(11, "a");
		map.put(13, "a");
		
		SortedMap<Integer,String> sortedMap = map.tailMap(10);
		if(!sortedMap.isEmpty()){
			System.out.println(sortedMap.firstKey());
		}
	}
	
	
	public static void main(String[] args){
		new MapConnectionTest().testTreeMap();
	}
}
