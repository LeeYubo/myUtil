package com.lyb.thread.latch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
	final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws InterruptedException {
    	CountDownLatch latch=new CountDownLatch(2);//两个工人的协作
    	Worker worker1=new Worker("zhang san", 5000, latch);
    	Worker worker2=new Worker("li si", 8000, latch);
    	worker1.start();//
    	worker2.start();//
    	//latch.await();//等待所有工人完成工作
    	System.out.println("所有线程启动完成...");
    	boolean result = latch.await(9000, TimeUnit.MILLISECONDS);//带上时间的含义是，我只等待这么长时间，然后就直接往下执行了，
    	System.out.println("result = "+result);
    	// 如果有的线程还没有执行完，可以在之后继续执行。只是不会一直阻塞到这儿。
    	
        System.out.println("all work done at "+sdf.format(new Date()));
	}
    
    
    static class Worker extends Thread{
    	String workerName; 
    	int workTime;
    	CountDownLatch latch;
    	public Worker(String workerName ,int workTime ,CountDownLatch latch){
    		 this.workerName=workerName;
    		 this.workTime=workTime;
    		 this.latch=latch;
    	}
    	public void run(){
            try {
                System.out.println("Worker "+workerName+" do work begin at "+sdf.format(new Date()));
    		    doWork();//工作了
    		    System.out.println("Worker "+workerName+" do work complete at "+sdf.format(new Date()));
            } finally {
            	// 为了避免出现问题，countDown最好放在finally里执行
                latch.countDown();//工人完成工作，计数器减一
            }
    	}
    	
    	private void doWork(){
    		try {
				Thread.sleep(workTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}
