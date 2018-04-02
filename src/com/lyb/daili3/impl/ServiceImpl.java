package com.lyb.daili3.impl;

import com.lyb.daili3.AService;
import com.lyb.daili3.BService;

public class ServiceImpl implements AService, BService {

	
	@Override
	public void doSomthingA(String str) {
		System.out.println("啊哈，我现在执行的是A接口的方法！"+str);
	}
	
	@Override
	public void doSomthingB() {
		System.out.println("啊哈，我现在执行的是B接口的方法！");
	}
}
