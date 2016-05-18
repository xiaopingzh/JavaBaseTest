package com.ping.list;

import java.util.HashSet;

public class SetTest {
	
	public void setToArrayaa(){
		Long[] idlongs = new Long[10];
		for(int i=0;i<10;i++){
			idlongs[i] = Long.parseLong(String.valueOf(i));
		}
		
		
		
		for(int i=0;i<idlongs.length;i++){
			System.out.println(idlongs[i]);
		}
	}
	
	
	public static void main(String[] args){
		new SetTest().setToArrayaa();
	}
}	
