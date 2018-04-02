package com.lyb.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("我是主线程。。。");
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("子线程。。。");
				Thread.sleep(10000);
				return "呵呵哒";
			}
		});
		System.out.println("后续主线程。。。");
		
		System.out.println("输出："+future.get());
		System.out.println("主线程执行完...");
		executorService.shutdownNow();
	}
}
