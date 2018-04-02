package com.lyb.duanyan;

public class TestAssert {

	public static void main(String[] args) {
		String name = "liyubo";
		assert name.equals("liyubo");
		System.out.println("第一个断言已通过...");
		
		assert name.equals("lyb") : "名称不为liyubo";
		System.out.println("第二个断言已通过...");
	}
}
