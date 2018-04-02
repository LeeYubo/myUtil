package com.lyb.model.factory.simplefactory;

public class UserNameLogin implements InterfaceLogin {

	UserNameLogin(){
		System.out.println("口令认证构造方法！");
	}
	
	@Override
	public boolean verify(String username, String password) {
		System.out.println("口令认证成功，可以登录！");
		return true;
	}
}
