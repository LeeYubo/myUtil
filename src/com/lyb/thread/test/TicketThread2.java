package com.lyb.thread.test;

public class TicketThread2 implements Runnable{

	private static int ticketNum = 100;
	public String name;
	
	public TicketThread2(String name){
		this.name = name;
	}

	public void run() {
		// 当还有剩余票的时候，就去执行
		System.out.println("----"+name+"----1---程序开始");
		while (ticketNum > 0) {
			synchronized (this) {
				System.out.println("----"+name+"----2---票数减一 开始");
				ticketNum--;
				System.out.println("----"+name+"----3---票数减一 结束");
				// 打印剩余票的数量
				if (ticketNum >= 0) {
					System.out.println("----"+name+"----4---打印成功");
					System.out.println("----"+name+"----售票成功，剩余票数： " + ticketNum);
				} else {
					System.out.println("----"+name+"----4---打印失败");
					System.out.println("----"+name+"----售票失败，票已售罄！");
				}
			}
			System.out.println("----"+name+"----5---打印完成");
			try {
				System.out.println("----"+name+"----6---开始休眠");
				Thread.sleep(1);
				System.out.println("----"+name+"----6---休眠结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("----"+name+"----7---退出");
		}
	}

	public static void main(String[] args) {
		for(int i=1;i<=10;i++){
			String threadName = "线程"+i;
			TicketThread2 first = new TicketThread2(threadName);
			Thread thread = new Thread(first);
			thread.start();
		}
	}
}
