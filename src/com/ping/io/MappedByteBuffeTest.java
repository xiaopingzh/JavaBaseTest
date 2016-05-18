package com.ping.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBuffeTest {

	private  static  String filepath = "/Users/a58/javatest/test1.txt";
	
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream(filepath);
			int sum=0;
			int n;
			long t1=System.currentTimeMillis();
			try {
				while((n=fis.read())>=0){
					//sum+=n;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long t=System.currentTimeMillis()-t1;
			System.out.println("sum:"+sum+"  time:"+t);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis=new FileInputStream(filepath);
			BufferedInputStream bis=new BufferedInputStream(fis);
			int sum=0;
			int n;
			long t1=System.currentTimeMillis();
			try {
				while((n=bis.read())>=0){
					//sum+=n;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long t=System.currentTimeMillis()-t1;
			System.out.println("sum:"+sum+"  time:"+t);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * NIO 内存映射文件
		 */
		MappedByteBuffer buffer=null;
		try {
			buffer=new RandomAccessFile(filepath,"rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1253244);
			int sum=0;
			int n;
			long t1=System.currentTimeMillis();
			for(int i=0;i<1253244;i++){
				//n=0x000000ff&buffer.get(i);
				//sum+=n;
			}
			long t=System.currentTimeMillis()-t1;
			System.out.println("sum:"+sum+"  time:"+t);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

