package com.lyb.concurrent;

public class SynchronizedDemo {
	private boolean start = false;
	private int result = 0;
	private int count = 0;

	// 读操作
	public void write() {
		start = true;
		count = 10;
	}

	// 写操作
	public void read() {
		if (start) {
			result = count * 5;
		}
		System.out.println("result的值为" + result);
	}

	class ReadWriteThread extends Thread {

		@Override
		public void run() {
			System.out.println("result = "+Thread.currentThread().getName()+" ----- "+result);
		}
	}

	public static void main(String[] args) {
		SynchronizedDemo demo = new SynchronizedDemo();
		demo.result = 100;
		demo.new ReadWriteThread().start();
		demo.new ReadWriteThread().start();
		demo.new ReadWriteThread().start();
		demo.new ReadWriteThread().start();
		demo.new ReadWriteThread().start();

	}
}