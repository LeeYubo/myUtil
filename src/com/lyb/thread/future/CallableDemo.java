package com.lyb.thread.future;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		return "just a test for FutureTask.";
	}

}
