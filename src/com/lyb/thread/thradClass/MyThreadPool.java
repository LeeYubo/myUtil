package com.lyb.thread.thradClass;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lyb.log.Log;

public class MyThreadPool extends Thread {
	
	private String command;

	public MyThreadPool(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		Log.getLogger().info(Thread.currentThread().getName()+" Start. Command = " + command);
		processCommand();
		Log.getLogger().info(Thread.currentThread().getName()+" End. Command = " + command);
	}

	private void processCommand() {
		while(!Thread.interrupted()){
			Log.getLogger().info(" --- 继续开始！ --- ");
			Log.getLogger().info(" ------ "+Thread.interrupted());
			Log.getLogger().info("A001");
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
	
	
	public static void main(String[] args) {
		Log.getLogger().info("A00001");
		ExecutorService executor = Executors.newFixedThreadPool(5);
		Log.getLogger().info("A00002");
		for (int i = 1; i <= 10; i++) {
			Log.getLogger().info("A00003.00001 "+i);
			Runnable worker = new MyThreadPool("liyubo" + i);
			Log.getLogger().info("A00003.00002 "+i);
			executor.execute(worker);
			Log.getLogger().info("A00003.00003 "+i);
		}
		
		
		
		Log.getLogger().info("A00004");
//		executor.shutdown();
		//当任务中有死循环时，并不能
		List<Runnable> list = executor.shutdownNow();
		
		Log.getLogger().info(" 等待的队列 =  "+list.size());
		
		Log.getLogger().info("A00005");
		Log.getLogger().info(executor.isTerminated());
		
		while (!executor.isTerminated()) {
			Log.getLogger().info("A00006");
		}
		Log.getLogger().info(executor.isTerminated());
		Log.getLogger().info("Finished all threads!");
	}
}