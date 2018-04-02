package com.lyb.holder;

import javax.xml.ws.Holder;

public class HolderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Holder<String> holder = new Holder<String>();
		holder.value="liyubo";
		System.out.println("holder value is :"+holder.value);
	}

}
