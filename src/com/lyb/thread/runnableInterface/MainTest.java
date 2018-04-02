package com.lyb.thread.runnableInterface;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread firstThread = new MyThread("First");
		MyThread secondThread = new MyThread("Second");
		MyThread thirdThread = new MyThread("Third");
		
		firstThread.start();
		secondThread.start();
		thirdThread.start();
	}
}