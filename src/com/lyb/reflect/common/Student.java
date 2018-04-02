package com.lyb.reflect.common;

public class Student {

	private String name = "liyubo";
	private Integer age = 22;
	private String className = "Infomation & Tecknology";
	
	public Student(){};
	
	public Student(String name, Integer age, String className){
		this.name = name;
		this.age = age;
		this.className = className;
	}
	
	public int getGradeCount(){
		System.out.println("获取总分数！");
		return 100;
	}
	
	private String introduce(String gender){
		System.out.println("自我说明！");
		return "My name is "+name+".I am a "+gender+".Today is "+age+"years old.My class is"+className;
	}
}
