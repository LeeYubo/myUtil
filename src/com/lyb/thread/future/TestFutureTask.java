package com.lyb.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFutureTask {

	public static void main(String[] args) {
		System.out.println("主线程...");
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		CallableDemo callable = new CallableDemo();
		MyFutureTask futureTask = new MyFutureTask(callable);
		
		executorService.submit(futureTask);
		executorService.shutdown();
		System.out.println("开始获取结果...");
		try {
			System.out.println("执行结果="+futureTask.get());
			
			System.out.println("到此结果已经获取完毕...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	static class CallableDemo implements Callable<String> {
		@Override
		public String call() throws Exception {
			Thread.sleep(5000);
			return "just a test for FutureTask.";
		}
		
	}
}
