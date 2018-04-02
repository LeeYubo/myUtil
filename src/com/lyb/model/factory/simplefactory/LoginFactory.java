package com.lyb.model.factory.simplefactory;

public class LoginFactory {

	public static InterfaceLogin getLogin(String loginType){
		
		if("username".equals(loginType)){
			return new UserNameLogin();
		}else if("domain".equals(loginType)){
			return new DomainLogin();
		}else{
			System.out.println("无法识别的登录方式！");
			return null;
		}
	}

}
