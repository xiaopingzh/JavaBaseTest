package com.ping.list;

import java.util.ArrayList;
import java.util.List;

public class ListRevertTest {
	
	public void revertList(){
		List<Long> list1  = new ArrayList<Long>();
		for(int i=0;i<100;i++){
			list1.add(Long.valueOf(i));
		}
		
		List<Long> list2  = new ArrayList<Long>();
		for(int i=0;i<50;i++){
			list2.add(Long.valueOf(i));
		}
		
		list1.removeAll(list2);
		for(int i =0;i<list1.size();i++){
			System.out.println(list1.get(i));
		}
	}
	
	
	public static void main(String[] args){
		new ListRevertTest().revertList();
	}
	
}	
