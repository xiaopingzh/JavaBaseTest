package com.ping.base;

import java.net.URLDecoder;

public class URLEncode {
	
	public void encodeTest(){
		String src  = "sdhfdhf\\sdf";
		try {
			src = URLDecoder.decode(src, "UTF-8");
			System.out.println(src);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new URLEncode().encodeTest();
	}
}
