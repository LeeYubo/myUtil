package com.lyb.fanxing;

public class DemoGenMethod {

	public static <T> void showGen(T t){
		System.out.println(""+t.getClass().getName());
	}
	
	public static <T> void showGen(T t, Integer i){
		System.out.println("i = "+i);
		System.out.println(""+t.getClass().getName());
	}
	
	public static <T> void test(int a,int b){
		
	}
	
	public static void main(String[] args) {
		Integer integer = 34;
		String str2 = "hello";
		DemoGenMethod.showGen(integer);
		DemoGenMethod.showGen(str2);
	}
}
