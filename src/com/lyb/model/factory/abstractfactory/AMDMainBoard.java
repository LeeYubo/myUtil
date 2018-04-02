package com.lyb.model.factory.abstractfactory;

public class AMDMainBoard implements MainBoard{

	public int cpuHoles = 0;
	
	public AMDMainBoard(int cpuHoles){
		this.cpuHoles = cpuHoles;
	}
	
	@Override
	public void initMainBoard() {
		System.out.println("初始化AMD主板，CPU针孔数："+cpuHoles);
	}
}
