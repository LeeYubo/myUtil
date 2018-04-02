package com.lyb.model.factory.abstractfactory;

public class AMDCPU implements CPU {

	public int pins = 0;
	
	public AMDCPU(int pins){
		this.pins = pins;
	}
	
	public void calculate() {
		System.out.println("AMD CPU 的针脚数 = "+pins);
	}

}
