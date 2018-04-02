package com.lyb.thread.thradClass;

import com.lyb.log.Log;

public class MyThread extends Thread {

	public static int count = 0;
	private static Object lock = new Object();

	public void run() {
		Log.getLogger().info(" -- start -- " + getName());
		while (count < 10000) {
//			Log.getLogger().info(" --- " + getName());
			synchronized (lock) {
//				Log.getLogger().info("        1       " + " count= "+ count + "  " + getName());
				if(count>=10000){
					return;
				}
				count = count + 1;
//				Log.getLogger().info("        2       " + " count= "+ count + "  " + getName());
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Log.getLogger().info(" -- end -- " + getName());
	}
	
	
	public static void main(String[] args){
		
		
		int N = Runtime.getRuntime().availableProcessors();
		System.out.println("CPU的数目 = "+N);
		
//		int threadNum = 10;
//		String name = "线程";
//		for(int i=1;i<=threadNum;i++){
//			name += i;
//			new MyThread().start();
//		}
		
		
//		MyThread first,scond,third,four,five,six;
//		first = new MyThread();
//		first.setName("first");
//		scond = new MyThread();
//		scond.setName("scond");
//		third = new MyThread();
//		third.setName("third");
//		four = new MyThread();
//		four.setName("four ");
//		five = new MyThread();
//		five.setName("five ");
//		six = new MyThread();
//		six.setName("six  ");
		
//		MyThread seven,eight,nine,ten;
//		seven = new MyThread();
//		eight = new MyThread();
//		nine = new MyThread();
//		ten = new MyThread();
//		
//		seven.setName("seven");
//		eight.setName("eight");
//		nine.setName("nine");
//		ten.setName("ten");
//		
//		first.start();
//		scond.start();
//		third.start();
//		four.start();
//		five.start();
//		six.start();
//		
//		seven.start();
//		eight.start();
//		nine.start();
//		ten.start();
	}
}