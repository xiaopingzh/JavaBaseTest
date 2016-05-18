package com.ping.sort;

import java.util.Arrays;

/**
 * 二分查找、二叉树查询
 * @author 
 *
 * 2015年10月26日 下午11:55:29
 */
public class TestSearch {
	
	//实现n的阶乘
//	public int test01(int m){
//		Class<com.ping.search.TestSearch> theclass = TestSearch.class;
//		if(m==1){
//			return m;
//		}
//		return m*test01(m-1);
//	}
	
	
	Integer[] in = {1,2,3,5,6,7,8,9,10,11};
	
	public int search(){
		
		int start = 0;
		int end = in.length-1;
		
		int index=  start;
		
		int key = 4;
		while(start <= end){
			index = (start + end)>>1;
			if( in[index] == key){
				return index;
			}else if(in[index] < key){
				start = index + 1;
			}else{
				end = index - 1;
			}
		}
		return start-1;
	}
	
	
	
	/**
	 * 二分查询
	 * 
	 * Arrays.binarySearch
	 */
	public void test02(){
		int[] ints = {1,4,2,6,5,3,7,8,9,11,12,14,15,16,17};
		Arrays.sort(ints);//排序
		int addrres = Arrays.binarySearch(ints, 14);//JDK提供的二分查找
		System.out.println(addrres);
	}
	
	/**
	 * Arrays.binarySearch(ints, 14)
	 * 源码如下
	 *  binarySearch0(a, 0, a.length, key)
	 * @param a
	 * @param fromIndex 一般为0
	 * @param toIndex  为a.length
	 * @param key	查询的值
	 * @return
	 */
	public int binarySearch0(int[] a, int fromIndex, int toIndex,int key) {
		int low = fromIndex;
		int high = toIndex - 1;
		
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];
			
			if (midVal < key){
				low = mid + 1;
			}else if (midVal > key){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return -(low + 1);  // key not found.
	}
	
	
	public int binarySearch(int[] a,int key){
		int low = 0;
		int high = a.length - 1;
		
		while(low <= high){
			int mid  = (low + high) >>> 1;
			
			if(a[mid] < key){
				low = mid + 1;
			}else if(a[mid] > key){
				high = mid-1;
			}else{
				return mid;
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args){
//		TestSearch test = new TestSearch();
		System.out.println(15>>1);
	}
}
