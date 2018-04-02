package com.lyb.thread.runnableInterface;

public class Synchonize {

	public static void main(String[] args) {
		
		/*
		 * 这种情况下，只会有一个线程打印tt对象中的变量，因为虽然启动了四个线程，但是操作的对象都是tt对象，并且对tt对象中的属性加了锁，一个时间内只能有一个线程操作。
		 * 如果不加锁，会是四个线程同时操作tt对象中的num变量。
		 * */
		TxtThread tt = new TxtThread();
		Thread t1 = new Thread(tt);
		Thread t2 = new Thread(tt);
		Thread t3 = new Thread(tt);
		Thread t4 = new Thread(tt);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}

class TxtThread implements Runnable {
	int num = 100;
	String str = new String();

	public void run() {
		System.out.println(Thread.currentThread().getName()+"---------------------------");
		synchronized (str) {
			while (num > 0) {

				try {
					Thread.sleep(1);
					System.out.println(Thread.currentThread().getName() + " this is " + num--);
				} catch (Exception e) {
					e.getMessage();
				}
			}
		}
	}
}
