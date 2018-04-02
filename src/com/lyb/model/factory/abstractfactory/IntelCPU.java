package com.lyb.model.factory.abstractfactory;

public class IntelCPU implements CPU {

	public int pins = 0;
	
	
	public IntelCPU(int pins){
		this.pins = pins;
	}
	
	
	@Override
	public void calculate() {
		System.out.println("Intel CPU 的针脚数 = "+pins);
	}

}
