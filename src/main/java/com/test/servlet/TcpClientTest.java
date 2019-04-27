/**
 *
 */
package com.test.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author aubrey
 * @date  上午10:55:05
 * 
 */
public class TcpClientTest {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8001);
		DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
		dataOut.writeUTF("我是客户端client");
		
		DataInputStream dataIn = new DataInputStream(socket.getInputStream());
		System.out.println(dataIn.readUTF());
		
		socket.close();
		
		
		
		
		
		
		
		
		
		
		
	}
}
