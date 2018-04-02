package com.lyb.daili;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 生成真实的实现类，即委托类
		Subject rs = new RealSubject();
		
		// 根据委托类生成代理类
		InvocationHandler ds=new DynamicSubject(rs);
		
		// 以下是一次性生成代理
		Subject subject=(Subject) Proxy.newProxyInstance(rs.getClass().getClassLoader(),rs.getClass().getInterfaces(), ds);
		
		
		// 这里可以通过运行结果证明subject是Proxy的一个实例，这个实例实现了Subject接口
		System.out.println(subject instanceof Proxy);
		// 这里可以看出subject的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了Subject接口
		System.out.println("subject的Class类是："+subject.getClass().toString());
		System.out.print("subject中的属性有：");
		Field[] field=subject.getClass().getDeclaredFields();
		for(Field f:field){
			System.out.print(f.getName()+", ");
		}
		System.out.print("\n"+"subject中的方法有：");
		Method[] method=subject.getClass().getDeclaredMethods();
		for(Method m:method){
			System.out.print(m.getName()+", ");
		}
		
		System.out.println("\n"+"subject的父类是："+subject.getClass().getSuperclass());
		System.out.print("\n"+"subject实现的接口是：");
		Class[] interfaces=subject.getClass().getInterfaces();
		for(Class i:interfaces){
			System.out.print(i.getName()+", ");
		}
		System.out.println("\n\n"+"运行结果为：");
		subject.request();
		
	}

}
