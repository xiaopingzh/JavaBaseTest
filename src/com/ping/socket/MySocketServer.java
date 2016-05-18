package com.ping.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

import com.ping.log.WriteFile;

/**
 * socket server
 * 
 * @author
 *
 *         2016年1月25日 下午4:06:23
 */
public class MySocketServer {

	public void initSocketServer() {
		// 为了简单起见，所有的异常信息都往外抛
		ServerSocket server = null;
		try {
			int port = 8899;
			// 定义一个ServerSocket监听在端口8899上
			server = new ServerSocket(port);
			while(true){
				//1）阻塞： server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的，创建线程池，用户异步处理
				Socket socket = server.accept();
				//跟客户端建立好连接之后，我们就可以获取socket的InputStream，并从中读取客户端发过来的信息了。
				Reader reader = new InputStreamReader(socket.getInputStream());
				char chars[] = new char[64];
				int len;
				StringBuilder sb = new StringBuilder();
				//2）阻塞：若没有读入足够的数据，也会阻塞等待读入足够的数据
				while ((len = reader.read(chars)) != -1) {
					sb.append(new String(chars, 0, len));
				}
				WriteFile.write("socketService.txt", "from client: " + sb + "," + socket.isConnected() + " " + socket.isInputShutdown());
				reader.close();
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) throws IOException {
		new MySocketServer().initSocketServer();
		System.out.println(Thread.currentThread().getThreadGroup() + " "
				+ Thread.currentThread().getName());
	}

}
