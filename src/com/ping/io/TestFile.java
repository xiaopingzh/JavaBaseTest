package com.ping.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;


/**
 * 
 * @author 
 *
 * 2016年3月20日 下午4:33:56
 */
public class TestFile {
	
	private String directory = "/Users/a58/javatest/test1.txt";
	
	/**
	 * inputStream 输入字节流
	 * @throws Exception
	 */
	public void inputStream() throws Exception{
		String directory = "/Users/a58/javatest/test1.txt";
		File file = new File(directory);
		if(file.exists() && file.isFile()){
			InputStream input = new FileInputStream(file);
			byte[] bufferBytes = new byte[(int)file.length()];
			while( input.read(bufferBytes) !=-1){
				System.out.println(new String(bufferBytes));
			}
			input.close();
		}
	}
	
	
	
	public void inputStreamTest(){
		try{
			File file = new File(directory);
			if(file.exists() && file.isFile()){
				InputStream inputStream = new FileInputStream(file);
				byte[] bufferBytes = new byte[(int)file.length()];
				while(inputStream.read(bufferBytes) != -1){
					System.out.println(new String(bufferBytes));
				}
				inputStream.close();
			}
		}catch(Exception e){
		}
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void inputstreamByte() throws Exception{
		InputStream input = new FileInputStream(new File(directory));
		int temp = 0;
		int length = 0;
		byte[] bytes = new byte[1024];
		while((temp=input.read()) !=-1){
			System.out.println(temp + " " + (byte)temp);
			bytes[length] = (byte)temp;
			length++;
		}
		input.close();
		System.out.println(new String(bytes, 0, length));
		
		ByteArrayInputStream byteinput = new ByteArrayInputStream(bytes, 0, length);
		int temp1 = 0;
		int length1 =0;
		while((temp1 = byteinput.read()) !=-1){
			System.out.println((byte)temp1);
		}
		
	}
	
	
	
	/**
	 * java.io.InputStream
	 * @throws Exception 
	 */
	public void outStreamTest() throws Exception{
		String directory = "/Users/a58/javatest/test1.txt";
		File file = new File(directory);
		PrintWriter printWrite = null;
		if(file.exists() && file.isFile()){
			OutputStream out = new FileOutputStream(file,true);
			printWrite = new PrintWriter(out);
			
			for(int i=0;i<10;i++){
				printWrite.println("你好\r");
//				out.write("outputstream".getBytes());
//				out.close();
			}
			printWrite.flush();
			out.close();
			printWrite.close();
			
			inputStream();
		}
	}
	
	/**
	 * java.io.FileReader
	 * 读取的是汉字，由于汉字占2个字节，因此如果以inputStream.read()读取长度超过了8bit,即0~255
	 * @throws Exception
	 */
	public void fileread() throws Exception{
		if(fileExist()){
			Reader filereader = new FileReader(new File(directory));
			char[] cbuf = new char[1024]; 
			int temp =0;
			int len =0;
			while((temp=filereader.read()) !=-1){
				System.out.println(temp + " " + (char)temp);
				cbuf[len] = (char)temp;
				len++;
			}
			filereader.close();
			
//			char[] cbuf = new char[1024];
//			int len = filereader.read(cbuf);
//			System.out.println(len);
//			filereader.close();
			System.out.println(new String(cbuf, 0, len));
		}
	}
	
	
	/**
	 * java.io.write
	 * @throws Exception
	 */
	public void filewrite() throws Exception{
		if(fileExist()){
			FileWriter write = new FileWriter(new File(directory),true);
			write.write("代码");
			write.close();
			
			inputStream();
		}
	}
	
	
	public boolean fileExist() throws Exception{
		File file = new File(directory);
		return (file.exists() && file.isFile());
	}
	
	public static void main(String[] args) throws Exception{
		new TestFile().inputstreamByte();
//		new TestFile().fileread();
	}
}
