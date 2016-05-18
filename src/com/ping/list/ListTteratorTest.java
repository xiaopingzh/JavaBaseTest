package com.ping.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * java.util.ListIterator interface
 * defferent with java.util.Iterator
 * @author zhangxiaoping
 *
 * 2015年5月16日 下午12:19:33
 */
public class ListTteratorTest {
	
	/**
	 * java.util.ListIterator 
	 */
	public void listIterator(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		
		ListIterator<Integer> li = list.listIterator();
		// 将游标定位到列表结尾
		for (li = list.listIterator(); li.hasNext();) {
            li.next();
        }
        for (; li.hasPrevious();) {// 逆序输出列表中的元素
            System.out.print(li.previous() + " ");
        }
	}
	
	public static void main(String[] args){
//		new ListTteratorTest().listIterator();
		int ss = 10;
		long a =ss;
		System.out.println(a);
	}
}
