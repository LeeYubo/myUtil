package com.lyb.timer;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTask task = new MyTask();
		
		timer.schedule(task,1000,10000);
	}
}

class MyTask extends TimerTask {

	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println("My name is "+Thread.currentThread().getName()+" "+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		
//		try {
//			System.out.println("I am ok!I will sleep here for 10 seconds.");
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}