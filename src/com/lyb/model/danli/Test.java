package com.lyb.model.danli;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		//1、饿汉式单例
//		HungrySingleton hungryInstance = null;
//		//该方法为HungrySingleton的静态方法，调用该方法时会自动加载类HungrySingleton；
//		//加载类时会自动生成类的静态变量，所以这个时候会创建类HungrySingleton的实例instance，会调用构造方法
//		hungryInstance = HungrySingleton.getInstance();
//		System.out.println(hungryInstance);
//		
//		System.out.println("\n\n");
//		
//		//2、懒汉式单例
//		LazySingleton lazyInstance = null;
//		lazyInstance = LazySingleton.getInstance();
//		System.out.println(lazyInstance);
		
		Class<HungrySingleton2> hungrySingleton2 = (Class<HungrySingleton2>) Class.forName("com.lyb.danli.HungrySingleton2");
		System.out.println("hungrySingleton2 = "+hungrySingleton2);
//		HungrySingleton2 hungrySingleton = (HungrySingleton2)hungrySingleton2.newInstance();
//		System.out.println("hungrySingleton2.newInstance() = " + hungrySingleton);
		
//		System.out.println(HungrySingleton2.getInstance());
//		System.out.println(HungrySingleton2.test);
	}

}
