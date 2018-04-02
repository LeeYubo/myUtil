package com.lyb.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		for(int i=0; i<10; i++){
			Client client = new Client("client"+i);
			executor.submit(client);
		}
		
		executor.shutdown();
	}
	
}