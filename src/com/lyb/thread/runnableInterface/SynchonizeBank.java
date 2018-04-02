package com.lyb.thread.runnableInterface;

public class SynchonizeBank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int MAX_THREAD = 100;
		Account account = new Account("liyubo",1000);
		System.out.println("用户余额===="+account.amount);
		
		Thread[] threads = new Thread[MAX_THREAD];
		
		ThreadBank threadBank = new ThreadBank(account);
		
		for(int i=0;i<MAX_THREAD;i++){
			threads[i] = new Thread(threadBank);
			threads[i].start();
		}
	}
	
}

class Account{
	String name;
	float amount;
	
	public Account(String name,float amount){
		this.name=name;
		this.amount=amount;
	}
	
	/**
	 * 存钱
	 * @author Administrator
	 * @param  float
	 * */
	public void deposit(float f){
		System.out.print("存钱:"+f+" ");
		amount += f;
	}
	
	/**
	 * 取钱
	 * @author Administrator
	 * @param  float
	 * */
	public void withdraw(float f){
		System.out.print("取钱:"+f+" ");
		amount -= f;
	}
}

class ThreadBank implements Runnable{

	Account account = null;
	
	public ThreadBank(Account account){
		this.account = account;
	}
	
	@Override
	public void run() {
		synchronized(account){
			account.deposit(1000);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.withdraw(1000);
			System.out.print("线程="+Thread.currentThread().getName());
		}
		System.out.println(" 用户："+account.name+";余额===="+account.amount);
	}
	
}