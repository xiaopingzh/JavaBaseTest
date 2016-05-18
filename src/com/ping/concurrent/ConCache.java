package com.ping.concurrent;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 高并发情况下从内存中获取数据
 * @author zhangxiaoping
 *
 */
public class ConCache {

	private static ConcurrentHashMap<String, Item> cache = new ConcurrentHashMap<String, Item>();
	
	/**
	 * 获取数据
	 * 如果没有则根据key创建Item实体并跟新到cache中
	 * @return
	 */
	public Item getValueFormMap(){
		String key = "";
		Item item = null;
		
		item = cache.get(key);
		if(item == null){
			item = new Item();
			//Key不存在时放入，如果Key存在则不替换，并返回原来值
			Item oldItem = cache.putIfAbsent(key, item);
			if(oldItem != null){
				item = oldItem;
			}
		}
		
		/**
		 * 判断获取的value是否为空，如果为空则修改其值
		 * 另外Synchronized锁住的Item实体而不是ConcurrentHashMap提高了并发
		 */
		String value = item.getValue();
		if(value == null){
			synchronized(item){
				value = item.getValue();
				if(value  == null){
					value = loadValue(key);
					item.setValue(value);
				}
			}
		}
		return item;
	}
	
	private String loadValue(String key){
		return key;
	}
}

class Item{
	
	private String value;
	
	public Item(){
		
	}
	
	public Item(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
