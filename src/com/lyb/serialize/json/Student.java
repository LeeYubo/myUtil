package com.lyb.serialize.json;

public class Student {

	private int age;
	private String username;
	private String password;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", username=" + username + ", password="
				+ password + "]";
	}
}
