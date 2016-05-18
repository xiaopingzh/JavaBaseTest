package com.ping.base;

import java.nio.ByteBuffer;

public class UTFTest {
	
	public String filterOffUtf8Mb4(String text){
		try{
			byte[] bytes = text.getBytes("UTF-8");
			System.out.println(bytes.length);
			ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
			int i = 0;
			while (i < bytes.length) {
				short b = bytes[i];
				if (b > 0) {
					buffer.put(bytes[i++]);
					continue;
				}
				b += 256;
				if ((b ^ 0xC0) >> 4 == 0) {
					buffer.put(bytes, i, 2);
					i += 2;
				}
				else if ((b ^ 0xE0) >> 4 == 0) {
					buffer.put(bytes, i, 3);
					i += 3;
				}
				else if ((b ^ 0xF0) >> 4 == 0) {
					i += 4;
				}
			}
			buffer.flip();
			String ss = new String(buffer.array(), "utf-8");
			System.out.println(ss.length());
			return ss;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	
	public static void main(String[] args){
		System.out.println("=!hljl😜aa".length());
		System.out.println("=!hljl😜aa");
		System.out.println(new UTFTest().filterOffUtf8Mb4("=!hljl😜aa"));
	}
}
