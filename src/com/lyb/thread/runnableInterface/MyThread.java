package com.lyb.thread.runnableInterface;

public class MyThread extends Thread{

	public static int count = 0;
	public static boolean flag=true;
	
	public synchronized void run(){
		for(int i=0;i<100;i++){
			if(!flag){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			flag=false;
			count++;
			//System.out.println("My name is "+Thread.currentThread().getName()+" count= "+count);
			flag=true;
			notifyAll();
			System.out.println("My name is "+Thread.currentThread().getName()+" count= "+count);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public MyThread(String name){
		super(name);
	}
}
