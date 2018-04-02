package com.lyb.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>标题: 测试变量，</p>
 * <p>描述: </p>
 * <p>公司: www.tydic.com</p>
 * @autho Yubo Lee
 * @time 2017年9月30日 上午9:04:22
*/
public class VariableTest {

	private static Long number = 0L;
	private static AtomicLong numberTwo ;

	public static void main(String[] args) {
		numberTwo = new AtomicLong();
		for (int i = 0; i < 100; i++) {
			Calculate cacl = new Calculate();
			Thread thread = new Thread(cacl);
			thread.start();
		}
	}
	
	
	private synchronized int add(int a,int b){
		return a+b;
	}
	
	private synchronized int add2(int a,int b){
		return a+b;
	}
	
	static class Calculate implements Runnable{
		@Override
		public void run() {
			System.out.println("Thread name = "+Thread.currentThread().getName()+",number = "+(numberTwo.getAndIncrement()));
		}
	}
}
