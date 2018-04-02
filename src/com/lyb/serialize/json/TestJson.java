package com.lyb.serialize.json;

import com.alibaba.fastjson.JSON;

public class TestJson {

	public static void main(String[] args) {
		Student student = new Student();
		student.setAge(10);
		student.setUsername("liyubo");
		student.setPassword("liyubo0000");
		String jsonString = JSON.toJSONString(student);
		Student student2 = JSON.parseObject(jsonString, Student.class);
		System.out.println(student2);
	}
}
