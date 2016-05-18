package com.ping.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 *  读取txt文件
 *  BufferReader
 *  InputStreamReader
 * @author a58
 *
 */
public class ReadTxt {
	//使用字符流读取文件
	private static String txtpath = "/Users/a58/javatest/test1.txt";
	public static void main(String[] args){
	    try {
		    String encoding="UTF-8";
		    File file=new File(txtpath);
		    if(file.isFile() && file.exists()){ //判断文件是否存在
		        InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
		        BufferedReader bufferedReader = new BufferedReader(read);
		        String lineTxt = null;
		        while((lineTxt = bufferedReader.readLine()) != null){
		            System.out.println(lineTxt);
		        }
		        read.close();
		  }else{
		      System.out.println("找不到指定的文件");
		  }
	  } catch (Exception e) {
	      System.out.println("读取文件内容出错");
	      e.printStackTrace();
	  }
	}
}
