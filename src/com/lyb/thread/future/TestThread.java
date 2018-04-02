package com.lyb.thread.future;

public class TestThread {

	/**
	 * <p>方法名称：测试主线程中启动一个线程，会不会阻塞</p>
	 * <p>方法说明：</p>
	 * @param args
	 * @autho Yubo Lee
	 * @time 2017年9月17日 上午10:22:42
	 */
	public static void main(String[] args) {
		System.out.println("我是主线程，下面我将开启一个子线程。");
		new Thread(new Runnable() {
			public void run() {
				System.out.println("我是一个内部线程...");
				System.out.println("我歇个5秒钟.");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("子线程执行完了...");
			}
		}).start();
		
		System.out.println("我是主线程的后半段");
	}
}
