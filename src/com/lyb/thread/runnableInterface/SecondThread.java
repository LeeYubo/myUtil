package com.lyb.thread.runnableInterface;

public class SecondThread extends Thread{

	private int ticket = 1500;  //5张票
	
	public void run() {     
		for (int i=0; i<=1500; i++) {             
			if (this.ticket > 0) {                 
				System.out.println(Thread.currentThread().getName()+ "正在卖票"+this.ticket--);             
			}         
		}     
	}

	public static void main(String [] args) {      
		SecondThread my = new SecondThread();         
		new Thread(my, "1号窗口").start();         
		new Thread(my, "2号窗口").start();         
		new Thread(my, "3号窗口").start();     
	}
}
