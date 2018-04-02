package com.lyb.model.danli;

public class HungrySingleton2 {

	private static class HungrySingletonHoder{
		private static final HungrySingleton2 instance = new HungrySingleton2();
	}

	public HungrySingleton2(){
		System.out.println("HungrySingleton2 构造函数被调用！");
	}
	
	public static final HungrySingleton2 getInstance(){
		return HungrySingletonHoder.instance;
	}
}
