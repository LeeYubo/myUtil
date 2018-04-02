package com.lyb.model.factory.abstractfactory;

public class IntelMainBoard implements MainBoard {

	public int cpuHoles = 0;
	
	public IntelMainBoard(int cpuHoles){
		this.cpuHoles = cpuHoles;
	}
	
	public void initMainBoard() {
		System.out.println("初始化Intel主板，CPU针孔数："+cpuHoles);
	}

}
