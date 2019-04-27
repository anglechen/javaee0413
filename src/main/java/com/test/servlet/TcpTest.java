/**
 *
 */
package com.test.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author aubrey
 * @date 上午10:46:59
 * 
 */
public class TcpTest {
	public static void main(String[] args) throws IOException {
//		new Socket(host, port);
		
		ServerSocket server = new ServerSocket(8001);
		System.out.println("初始化socketserver完成，等待连接......");
		Socket socket = server.accept();
		
		DataInputStream dataIn = new DataInputStream(socket.getInputStream());
		
		System.out.println(dataIn.readUTF());
		System.out.println("数据接收完毕......");
		
		DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
		
		dataOut.writeUTF("谢谢连接.......");
		
		socket.close();
		
	}
}
