package com.ping.socket;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * socket client
 * @author 
 *
 * 2016年1月25日 下午4:25:18
 */
public class MySocketClient {
	
	public void initMySocketClient(){
		// 为了简单起见，所有的异常都直接往外抛
		try{
			String host = "127.0.0.1"; // 要连接的服务端IP地址
			int port = 8899; // 要连接的服务端对应的监听端口
			// 与服务端建立连接,两种创建方式
//			new Socket().connect(endpoint, timeout);
			Socket client = new Socket(host, port);
			// 建立连接后就可以往服务端写数据了
			Writer writer = new OutputStreamWriter(client.getOutputStream());
			writer.write("Hello Server.");
			writer.flush();// 写完后要记得flush
			writer.close();
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]) throws Exception {
		new MySocketClient().initMySocketClient();
	}

}
