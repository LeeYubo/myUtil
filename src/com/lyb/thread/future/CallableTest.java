package com.lyb.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1); // (1)
		Future<String> future = executorService.submit(new CallableTask()); // (2)
		try {
			//
			System.out.println("开始阻塞式的等待获取结果，也就是说结果没有出来会一直卡在这..."); // (3)
			String result = future.get(); // (4)
			System.out.println("result = "+result); // (5)
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}
	
	// 内部类最好定义为静态的使用起来方便，不然使用的时候还需要先new一个外部类才能使用
	static class CallableTask implements Callable<String> {
		@Override
		public String call() throws Exception {
			System.out.println("call 方法被调用...001..."); // (6)
			Thread.sleep(10000);							   // (7)
			System.out.println("call 方法被调用...002..."); // (8)
			return "my name is liyubo";
		}
	} 
}
