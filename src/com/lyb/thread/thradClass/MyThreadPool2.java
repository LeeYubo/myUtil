package com.lyb.thread.thradClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.lyb.log.Log;

public class MyThreadPool2 extends Thread {
	
	private String command;
	
	MyThreadPool2(String name){
		this.command = name;
	}
	
	public void run() {
		Log.getLogger().info(Thread.currentThread().getName()+" Start. Command = "+command);
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        Log.getLogger().info(Thread.currentThread().getName()+" End. Command = "+command);
    }
	
	
	public static void main(String[] args) {
		
//		ExecutorService executor = Executors.newFixedThreadPool(5);
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		ExecutorService executor = Executors.newCachedThreadPool();
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

//		prestartAllCoreThreads
		for(int i=1;i<=10;i++){
			MyThreadPool2 thread = new MyThreadPool2("liyubo"+i);
			executor.execute(thread);
			//executor.schedule(thread, 3, TimeUnit.SECONDS);
			//executor.scheduleAtFixedRate(thread, 1, 30, TimeUnit.SECONDS);
		}
//		executor.shutdown();
	}
}