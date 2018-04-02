package com.lyb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("服务端启动：serverSocket "+serverSocket.toString());
			System.out.println("等待客户端连接...");
			while(true){
				Socket cilentSocket = null;
				BufferedReader streamReader = null;
				PrintStream printStream = null;
				try {
					cilentSocket = serverSocket.accept();
					System.out.println("新的连接已经建立，cilentSocket = "+cilentSocket);
					streamReader = new BufferedReader(new InputStreamReader(cilentSocket.getInputStream()));
					printStream = new PrintStream(cilentSocket.getOutputStream(), true);
					String request = null;
					String response = null;
					while((request=streamReader.readLine()) != null){
						if("bye".equals(request)){
							break;
						}
						String address = cilentSocket.getRemoteSocketAddress().toString();
						System.out.println("Client("+address+") said:"+request);
						System.out.print("小王：");
						BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
						response = consoleReader.readLine();
						if(null!=response && !response.equals("")){
							printStream.println(response);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					if(null!=printStream){
						printStream.close();
					}
					if(null!=streamReader){
						try {
							streamReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(null!=cilentSocket){
						try {
							cilentSocket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if(null!=serverSocket){
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
