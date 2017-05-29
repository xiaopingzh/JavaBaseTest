package com.ping.Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MapTest
 *
 */
public class MapTest{
	
	public static HashMap<String,String> map = new HashMap<String,String>();
	
	static{
		map.put("a", "a");
		map.put("b", "value");
	}
	
	/**
	 * Map 遍历
	 * 
	 * 最优
	 */
	public void testMap(){
		
//		HashMap<String,String> mymap = new HashMap<String,String>(1);
		StringBuffer str = new StringBuffer();
		
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> entry = iterator.next();
		}
	}
	
	
	public void treeMapTest(){
		
		TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
		treeMap.put(1, "a");
		treeMap.put(3, "a");
		treeMap.put(5, "a");
		treeMap.put(7, "a");
		treeMap.put(9, "a");
		
		// 获取 >= 6 的第一个节点
		
		int key;
		SortedMap<Integer, String> sortedMap =  treeMap.tailMap(6);
		if(!sortedMap.isEmpty()){
			key  = sortedMap.firstKey();
		}else{
			key = treeMap.firstKey();
		}
	
		System.out.println(key);
	}
	
	
	
	public void mapClear(){
		HashMap<String,String> map = new HashMap<String,String>();
		map.get("a");
		map.clear();
	
	
		TreeMap<String,String> treemap = new TreeMap<String,String>();
		treemap.clear();
	}
	
	public void testConcurrentHashMap(){
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String,String>();
		map.put("a", "a");
		map.get("a");
		
		
		//初始化参数值 一个 initialCapacity，表示初始的容量，一个 loadFactor，表示负载参数，最后一个是 concurrentLevel，代表 ConcurrentHashMap 内部的 Segment 的数量
//		ConcurrentHashMap<String,String> map1 = new ConcurrentHashMap<>(initialCapacity, loadFactor, concurrencyLevel);
	}
	
	
	final int cacheCount = 100;


	/**
	 * LinkedHashMap
	 *
	 */
	public void testLinkedHashMap(){
		//第三个参数false，表示按照顺序存储，true表示使用LRU算法，将刚获取的放到线性表尾
		LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>(16, 0.75f, true){
			@Override
			public boolean removeEldestEntry(Map.Entry<String, String> entity){
				return size() > 100;
			}
			
		};
		for(int i=0;i<10;i++){
			linkedHashMap.put(i+"", i+"");
		}
		
		for(int i=0;i<9;i++){
			linkedHashMap.get(i+"");
		}
		
		
		linkedHashMap.put("10", "value");
		for(String key:linkedHashMap.keySet()){
			System.out.println(key);
		}

	}

	/**
	 * 测试JDK1.8 HashMap
	 */
	public void testJDK8HashMap(){

		HashMap<String,String> map = new HashMap<String,String>();
	}


	static final int MAXIMUM_CAPACITY = 1 << 30;

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}


	public static void main(String[] args){
		System.out.println(tableSizeFor(7));
	}
	
}
