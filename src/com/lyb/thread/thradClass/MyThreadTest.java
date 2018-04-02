package com.lyb.thread.thradClass;

import com.lyb.log.Log;

public class MyThreadTest implements Runnable {

	@Override
	public void run() {		
		//检查程序是否发生中断
		while (!Thread.interrupted()) {
			System.out.println("I am running!");
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("A000000000001");
		MyThreadTest t1 = new MyThreadTest();
		Thread thread = new Thread(t1);
		thread.start();
		System.out.println(thread.isInterrupted());
		
		Thread.sleep(100);
		System.out.println("****************************");
		System.out.println("Interrupted Thread!");
		System.out.println("****************************");
		thread.interrupt();
		
		System.out.println(thread.isInterrupted());
		
	}
}