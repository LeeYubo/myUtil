package com.lyb.thread.tongbu;

class Account {
	String name;
	float amount;
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public Account(String name, float amount) {
		this.name = name;
		this.amount = amount;
	}

	public void deposit(float amt) {
		synchronized (lock1) {
			float tmp = amount;
			tmp += amt;

			try {
				Thread.sleep(1);//模拟其它处理所需要的时间，比如刷新数据库等
			} catch (InterruptedException e) {
				// ignore
			}
			amount = tmp;
		}
	}

	public void withdraw(float amt) {
		synchronized (lock2) {
			float tmp = amount;
			tmp -= amt;

			try {
				Thread.sleep(1);//模拟其它处理所需要的时间，比如刷新数据库等
			} catch (InterruptedException e) {
				// ignore
			}
			amount = tmp;
		}
	}

	public float getBalance() {
		return amount;
	}
}

public class AccountTest {
	private static int NUM_OF_THREAD = 1000;
	static Thread[] threads = new Thread[NUM_OF_THREAD];

	public static void main(String[] args) {
		final Account acc = new Account("John", 1000.0f);
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					acc.deposit(100.0f);
					acc.withdraw(100.0f);
				}
			});
			threads[i].start();
			System.out.println("i="+i);
		}
		
		System.out.println("--------------------------");
		
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			try {
				threads[i].join(); //等待所有线程运行结束
			} catch (InterruptedException e) {
				// ignore
			}
			System.out.println("==================");
		}
		System.out.println("Finally, John's balance is:" + acc.getBalance());
	}

}