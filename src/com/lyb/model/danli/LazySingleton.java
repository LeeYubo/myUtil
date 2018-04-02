package com.lyb.model.danli;

public class LazySingleton {

	private static LazySingleton instance = null;
	
	//私有的构造函数，只有在类内才可以被调用，即不能在外部被实例化
	private LazySingleton(){
	}
	
	public static synchronized LazySingleton getInstance(){
		if(null == instance){
			instance = new LazySingleton();
		}
		return instance;
	}
}
