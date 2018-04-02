package com.lyb.daili3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HandlerImpl implements InvocationHandler {

	private Object object;
	
	HandlerImpl(Object object){
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("可以在这随便添加点什么东西...");
		System.out.println(proxy.getClass().getName());
		System.out.println("方法名："+method);
		return method.invoke(object, args);
	}

}
