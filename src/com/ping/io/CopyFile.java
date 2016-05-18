package com.ping.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * copy file
 * @author a58
 *
 */
public class CopyFile {
	private String dir = "/Users/a58/javatest/";
	
	/**
	 * copy file(not contain dir)
	 */
	public void copyfile(){
		String sourceFilepath = dir + "test1.txt";
		String targetFilepath = dir + "test2.txt";
		
		InputStream input = null;
		BufferedOutputStream outbuffer = null;
		try{
			File  sourceFile = new File(sourceFilepath);
			input = new FileInputStream(sourceFile);
			outbuffer = new BufferedOutputStream(new FileOutputStream(targetFilepath,true));
			
			
			byte[] bytes = new byte[1024];
			int temp = 0;
			while((temp=input.read(bytes)) !=-1){
				outbuffer.write(bytes, 0, temp);
			}
			outbuffer.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(input != null){
					input.close();
				}
				if(outbuffer != null){
					outbuffer.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		new CopyFile().copyfile();
	}
}
