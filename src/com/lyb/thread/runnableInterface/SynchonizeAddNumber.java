package com.lyb.thread.runnableInterface;

public class SynchonizeAddNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("---------------the main function start......");
		ThreadAdd threadAdd = new ThreadAdd();
		Thread add1 = new Thread(threadAdd);
		Thread add2 = new Thread(threadAdd);
		Thread add3 = new Thread(threadAdd);
		Thread add4 = new Thread(threadAdd);
		add1.start();
		add2.start();
		add3.start();
		add4.start();
	}

}

class ThreadAdd implements Runnable{
	Count count = new Count();
	
	public void run() {
		for(int i=0;i<4000;i++){
			synchronized(count){
				count.value++;
			}
			System.out.println("My name is "+Thread.currentThread().getName()+" 累加值= "+count.value);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Count{
	int value=0;
}