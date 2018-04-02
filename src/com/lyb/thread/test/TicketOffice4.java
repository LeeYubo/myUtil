package com.lyb.thread.test;

import java.sql.Timestamp;

public class TicketOffice4 implements Runnable{
	
	public static int ticketNum = 1000;
	
    /** 
     *  已经进行了互斥控制。这里是通过synchronized修饰代码块实现的。线程要想进入修饰的代码块， 
     *  必须获取lock对象的对象标示。 
     */  
    private static Object lock = new Object();


    public static String getDate(){
    	String result = "";
    	java.util.Date date1 = new java.util.Date();
    	Timestamp stamp2 = new Timestamp(date1.getTime());
    	result = stamp2.toString();
    	return result;
    }
    
	public void run() {
		System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----1---程序开始");
		while(ticketNum > 0){
			synchronized(lock){
				System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----2---票数减一 开始");
				ticketNum--;
				System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----3---票数减一 结束");
	            // 打印剩余票的数量
	            if(ticketNum >= 0){
	            	System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----4---打印成功");
	            	System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----售票成功，剩余票数： " + ticketNum);  
	            }else{  
	            	System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----4---打印失败");
	                System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----售票失败，票已售罄！");  
	            }
	            
	        }
			System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----5---打印完成");
			for(int i=0;i<10;i++){
				System.out.println(" --- "+Thread.currentThread().getName()+" i ="+i);
			}
			System.out.println("\n");
//	        try {
//	        	System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----6---开始休眠");
//	        	Thread.sleep(10);
//	        	System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----7---休眠结束");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("----"+Thread.currentThread().getName()+"----"+getDate()+"----8---退出");
	}

	
	public static void main(String[] args) {
		
		// 启动10个线程，即10个窗口开始卖票
		for(int i=0;i<10;i++){
			TicketOffice4 first = new TicketOffice4();
			Thread thread = new Thread(first);
			thread.start();
		}
	}
	
}
