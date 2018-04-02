package com.lyb.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TestObjSerializeAndDeserialize {

	public static void main(String[] args) {
		File file = new java.io.File("d://test.txt");
		
		TestObjSerializeAndDeserialize test = new TestObjSerializeAndDeserialize();
		try {
			test.testSerialize(file);
			test.testDeserialize(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void testSerialize(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		Person person = new Person();
		person.setAge(20);
		person.setName("liyubo");
		person.setSex("boy");
		System.out.println("新建对象，person="+person);
		System.out.println("开始序列化...");
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
		outputStream.writeObject(person);
		System.out.println("person对象序列化成功！");
		outputStream.close();
	}
	
	public Person testDeserialize(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println("开始发序列化...");
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		Person person = (Person)inputStream.readObject();
		System.out.println("反序列化成功："+person);
		inputStream.close();
		return person;
	}
}
