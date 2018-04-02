package com.lyb.model.factory.simplefactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String loginType = "domain";
		InterfaceLogin login = LoginFactory.getLogin(loginType);
		
		if(null!=login){
			login.verify("123", "123");
		}
	}

}
