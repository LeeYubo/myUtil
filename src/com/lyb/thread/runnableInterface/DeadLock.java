package com.lyb.thread.runnableInterface;

public class DeadLock {
	public static void main(String[] args) {
		
		System.out.println("主线程的优先级是==="+Thread.currentThread().getPriority());
		
		Resource r1= new Resource();
		Resource r2= new Resource();
		//每个线程都拥有r1,r2两个对象
		Thread myTh1 = new MyThread1(r1,r2);
		Thread myTh2 = new MyThread2(r1,r2);
		myTh1.setPriority(10);
		myTh2.setPriority(1);
		myTh1.start();
		myTh2.start();
	}
}

class Resource{
	private int i;
}

class MyThread1 extends Thread{
	private Resource r1,r2;
	public MyThread1(Resource r1, Resource r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	@Override
	public void run() {
		while(true){
		//先获得r1的锁，再获得r2的锁	
		synchronized (r1) {
			System.out.println("1号线程获取了r1的锁");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("A000001");
			
//			synchronized (r2) {
//				System.out.println("1号线程获取了r2的锁");
//			}
		}
		}
	}
	
}

class MyThread2 extends Thread{
	private Resource r1,r2;
	public MyThread2(Resource r1, Resource r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	@Override
	public void run() {
		while(true){
		//先获得r2的锁，再获得r1的锁
		synchronized (r2) {
			System.out.println("2号线程获取了r2的锁");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("A000002");
//			synchronized (r1) {
//				System.out.println("2号线程获取了r1的锁");
//			}
		}
		}
	}
	
}