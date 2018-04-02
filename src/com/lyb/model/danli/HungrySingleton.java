package com.lyb.model.danli;

public class HungrySingleton {

	private static final HungrySingleton instance = new HungrySingleton();

	//类中的静态变量的生命周期与类的生命周期相同，在类被加载时会在内存中分配静态变量的内存，并初始化变量。
	//类在何时被加载，在new一个对象的时候会加载类，这时就会在内存中有类的静态变量
	//当类的静态变量被访问时也会自动加载类
	private HungrySingleton(){
		System.out.println("instance 1111 = "+instance);
	}
	
	public static HungrySingleton getInstance(){
		System.out.println("instance 2222 = "+instance);
		return instance;
	}

}
