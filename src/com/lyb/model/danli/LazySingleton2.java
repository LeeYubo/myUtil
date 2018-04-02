package com.lyb.model.danli;

public class LazySingleton2 {

	private static LazySingleton2 instance = null;
	//私有的构造方法
	private LazySingleton2(){}
	
	public static LazySingleton2 getInstance(){
		//先检查实例是否存在，如果不存在才进入下面的同步块
		if(null==instance){
			 //同步块，线程安全的创建实例
			synchronized (LazySingleton2.class) {
				//再次检查实例是否存在，如果不存在才真正的创建实例
				if(null==instance){
					instance = new LazySingleton2();
				}
			}
		}
		return instance;
	}
}
