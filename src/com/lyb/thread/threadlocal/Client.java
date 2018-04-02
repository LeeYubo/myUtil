package com.lyb.thread.threadlocal;

public class Client extends Thread {

	private int num = 0;
	
	private static Integer synNum = 0;
	
	static ThreadLocal<Integer> localInteger = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		};
	};
	
	Client(String name){
		super(name);
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName(); 
		for(int i=0;i<100;i++){
			num++;
			if(null!=localInteger.get()){
				localInteger.set(localInteger.get()+1);
			}
		}
		
		synchronized (synNum) {
			for(int i=0;i<100;i++){
				synNum++;
			}
		}
		
		System.out.println("线程："+threadName+" 正在执行. num = "+num + ",localInteger = "+localInteger.get()+" synNum = "+synNum);
	}

}
