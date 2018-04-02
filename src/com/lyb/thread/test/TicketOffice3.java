package com.lyb.thread.test;

public class TicketOffice3 {
	
	private int ticketNum = 0;

	public TicketOffice3(int ticketNum) {
		super();
		this.ticketNum = ticketNum;
	}
	
	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	
	/**
	 *  售票厅卖票的方法，这个方法操作了售票厅对象唯一的状态--剩余火车票数量。
	 *  该方法此处并未进行互斥控制。
	 */
	public void sellOneTicket(){
		
		ticketNum--;
		// 打印剩余票的数量
		if(ticketNum >= 0){
			
			System.out.println("售票成功，剩余票数： " + ticketNum);
		}else{
			
			System.out.println("售票失败，票已售罄！");
		}
		
	}
	
	
    /** 
     *  已经进行了互斥控制。这里是通过synchronized修饰代码块实现的。线程要想进入修饰的代码块， 
     *  必须获取lock对象的对象标示。 
     */  
    private Object lock = new Object();  
    public void sellOneTicket2(){  
          
        synchronized(lock){
            ticketNum--;  
            // 打印剩余票的数量
            System.out.print("---------"+Thread.currentThread().getName()+"-----------");
            if(ticketNum >= 0){  
                  
                System.out.println("售票成功，剩余票数： " + ticketNum);  
            }else{  
                  
                System.out.println("售票失败，票已售罄！");  
            }  
        }
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }  
	
	
	public static void main(String[] args) {
		
		final TicketOffice3 ticketOffice = new TicketOffice3(10000);
		
		// 启动10个线程，即10个窗口开始卖票
		for(int i=0;i<10;i++){
			
			new Thread(new Runnable(){

				@Override
				public void run() {
					
					// 当还有剩余票的时候，就去执行
					while(ticketOffice.getTicketNum() > 0){
//						System.out.print("---------"+Thread.currentThread().getName()+"-----------");
						ticketOffice.sellOneTicket2();
					}
					
				}
				
			}).start();
		}
	}

}
