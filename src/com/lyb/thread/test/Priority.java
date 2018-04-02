package com.lyb.thread.test;

public class Priority {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread1 thread1 = new MyThread1();
		MyThread2 thread2 = new MyThread2();
		MyThread3 thread3 = new MyThread3();
		
		thread1.setPriority(10);
		thread2.setPriority(1);
		thread3.setPriority(1);
		
		thread1.start();
		thread3.start();
		try {
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		
	}

}

class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("-----------------------");
		}
		while(true){
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A0000111111");
		}
	}
}

class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("+++++++++++++++++++++++");
		}
		while(true){
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A0000222222");
		}
	}
}

class MyThread3 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("***********************");
		}
		while(true){
//			try {
//				sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("A0000333333");
		}
	}
}