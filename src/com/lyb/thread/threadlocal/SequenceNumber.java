package com.lyb.thread.threadlocal;

public class SequenceNumber {

	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		};
	};
	
	public Integer getNext(){
		threadLocal.set(threadLocal.get()+1);
		return threadLocal.get();
	}
	
	public static void main(String[] args) {
		SequenceNumber sequenceNumber = new SequenceNumber();
		Client client1 = new Client("线程-1-",sequenceNumber);
		client1.start();
		Client client2 = new Client("线程-2-",sequenceNumber);
		client2.start();
		Client client3 = new Client("线程-3-",sequenceNumber);
		client3.start();
	}
	
	private static class Client extends Thread{

		private SequenceNumber sequenceNumber;
		
		Client(String name,SequenceNumber sequenceNumber){
			super(name);
			this.sequenceNumber = sequenceNumber;
		}
		
		@Override
		public void run() {
			for(int i=0;i<3;i++){
				System.out.println("Thread name = "+Thread.currentThread().getName()+", "+sequenceNumber.getNext());
			}
		}
	}
}
