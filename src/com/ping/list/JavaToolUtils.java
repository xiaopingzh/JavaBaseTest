package com.ping.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * java.util.Arrays
 * java.util.Collections
 * 等工具类的使用
 * @author zhangxiaoping
 *
 * 2015年7月19日 下午5:09:39
 */
public class JavaToolUtils {
	
	public List<String> getList(){
		List<String> list = new ArrayList<String>();
		for(int i=0;i<100;i++){
			list.add(i+"");
		}
		return list;
	}
	
	public Map<String,String> getMap(){
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<100;i++){
			String value = i+"";
			map.put(value, value);
		}
		return map;
	}
	
	/**
	 * HashMap 排序
	 */
	public void test01(){
		Map<String,String> map = getMap();
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		/**
		 * List 排序
		 * 自定义Comparator接口，实现compare方法
		 * 实际上调用的为Arrays.sort(a, (Comparator)c);
		 * 
		 * 归并排序
		 */
		List<Entry<String,String>> list = 	new ArrayList<Entry<String,String>>(entrySet);
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
	}
	
	/**
	 * Collections
	 */
	public void CollectionsTest(){
		
		List<String> list = getList();
		
		/**
		 * 取交集
		 */
		list.retainAll(list);
		
		
		/**
		 * list排序
		 * 实际上转换为Arrays.sort(list.toArray())
		 * 对(int,float)等基本数据类型采用快速排序
		 * 对Object[] 使用归并排序
		 */
		Collections.sort(list);
		
		/**
		 * list 倒排序
		 */
		Collections.reverse(list);
		
		/**
		 * 
		 */
		Collections.swap(list, 1, 2);
		
	}
	
	
	/**
	 * java.util.Arrays
	 * 
	 */
	public void ArraysTest(){
		Object[] arr = getList().toArray();
		
		int[] arrInts = {1,4,5,2,3,9,8};
		
		/**
		 * 二分查找
		 */
		int num = Arrays.binarySearch(arrInts, 3);
		System.out.println(num);
		
		/**
		 * 排序
		 * 快速排序
		 */
		Arrays.sort(arr);
	}
	
	/**
	 * Map排序
	 * 先转换为List再排序
	 * @param map
	 */
	public void maptoList(Map<String,String> map){
		String ss = map.entrySet().toString();
		System.out.println(ss);
		
		ArrayList<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
		for(Map.Entry<String, String> mapentry:list){
			System.out.println(mapentry.getKey() + " " + mapentry.getValue());
		}
	}
	
	public static void main(String[] args){
		JavaToolUtils listtest = new JavaToolUtils();
//		listtest.maptoList(listtest.getMap());
		listtest.ArraysTest();
	}
}
