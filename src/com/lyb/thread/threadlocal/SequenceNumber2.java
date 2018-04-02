package com.lyb.thread.threadlocal;

public class SequenceNumber2 {

	
	private Integer number=0;
	
	public Integer getNext(){
		return number++;
	}
	
	public static void main(String[] args) {
		SequenceNumber2 sequenceNumber = new SequenceNumber2();
		Client client1 = new Client("线程-1-",sequenceNumber);
		client1.start();
		Client client2 = new Client("线程-2-",sequenceNumber);
		client2.start();
		Client client3 = new Client("线程-3-",sequenceNumber);
		client3.start();
	}
	
	private static class Client extends Thread{

		private SequenceNumber2 sequenceNumber;
		
		Client(String name,SequenceNumber2 sequenceNumber){
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
