package com.lyb.thread.thradClass.pool2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.lyb.log.Log;

public class Test {
	public static void main(String[] args) {
		/*ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
		
		for(int i=0;i<10;i++){
             MyTask myTask = new MyTask(i);
             executor.execute(myTask);
             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();*/
		
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
//		threadPool.prestartAllCoreThreads();
		
		MyTask myTask1 = new MyTask(1);
		threadPool.execute(myTask1);
		MyTask myTask2 = new MyTask(2);
		threadPool.execute(myTask2);
		
		Log.getLogger().info("11");
		threadPool.shutdown();
		Log.getLogger().info("22");
     }
}
 

class MyTask implements Runnable {
    private int taskNum;
    
    public MyTask(int num) {
        this.taskNum = num;
    }
     
    @Override
    public void run() {
    	Log.getLogger().info("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.getLogger().info("task "+taskNum+"执行完毕");
    }
}