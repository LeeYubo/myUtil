package com.lyb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		Socket socketClient = null;
		BufferedReader bufferedReader = null;
		PrintStream printStream = null;
		try {
			socketClient = new Socket("127.0.0.1", 10000);
			System.out.println("********** 客户端启动 **********");
			System.out.println("已成功连接至服务端，可以开始沟通。");
			System.out.print("小李（我）：");
			bufferedReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			printStream = new PrintStream(socketClient.getOutputStream(), true);
			String request = null;
			String response = null;
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			response = consoleReader.readLine();
			printStream.println(response);
			while((request = bufferedReader.readLine()) != null){
				if("bye".equals(request)){
					break;
				}
				String remoteAddress = socketClient.getRemoteSocketAddress().toString();
				System.out.println("Server("+remoteAddress+") said:"+request);
				System.out.print("小李（我）：");
				response = consoleReader.readLine();
				if(null!=response && !response.equals("")){
					printStream.println(response);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null!=printStream){
				printStream.close();
			}
			if(null!=bufferedReader){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null!=socketClient){
				try {
					socketClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
