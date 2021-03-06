package com.lyb.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyFutureTask extends FutureTask<String> {

	public MyFutureTask(Callable<String> callable) {
		super(callable);
	}

	@Override
	protected void done() {
		System.out.println("任务执行完成了...");
	}
}
