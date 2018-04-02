package com.lyb.model.factory.simplefactory;

public class DomainLogin implements InterfaceLogin {

	DomainLogin(){
		System.out.println("域名认证构造方法！");
	}
	
	public boolean verify(String username, String password) {
		System.out.println("域名认证成功，可以登录！");
		return true;
	}

}
