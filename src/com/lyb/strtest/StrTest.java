package com.lyb.strtest;

import org.apache.commons.lang.builder.ToStringBuilder;

public class StrTest {

	public static void main(String[] args) {
		Temp temp1 = new Temp("1111","2222");
		System.out.println(temp1);
	}

}

class Temp{
	String t1;
	String t2;
	
	Temp(String s1, String s2){
		this.t1 = s1;
		this.t2 = s2;
	}
	
	public String toString1() {
		return "t1=" + this.t1 + ";t2=" + this.t2;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
		.append("t1",t1).append("t2",t2).toString();
	}
}
