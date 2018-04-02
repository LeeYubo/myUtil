package com.lyb.interview;

public class StringTest {
	
	public static void main(String[] args) {
		
//		String s1 = "adc";
//		String s2 = "adc";
//		System.out.println(s1==s2);
//		true：s1与s2都引用string内存池中的变量，其在栈内存中的值相同。

//		String s1 = "adc";
//		String s2 = new String("adc");
//		System.out.println(s1==s2);
	
		String s1 = new String("adc");
		String s2 = new String("adc");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
//		false：s1与s2都分别在堆内存中创建，各自引用各自的变量，所以返回值为false。
//
//		String str="abc"+"def";   
//		System.out.println(str=="abcdef");
//		true：因为str变量会直接在字符串内存池中创建，字符串"abcdef"也在内存池中，所以返回为true。
//
//		String s1="abc";
//		String s2="def";
//		String str=s1+s2;
//		System.out.println(str=="abcdef");
//		false：如果在进行字符串的加运算时，表达式的右方有一个new对象，则在创建str对象时会在堆内存中先创建两个s1对象和s2对象，将其在内存池中的对象赋值到堆内存中，然后再在堆内存中创建str对象，而"abcdef"对象在内存池中，所以返回为false。
	}
}