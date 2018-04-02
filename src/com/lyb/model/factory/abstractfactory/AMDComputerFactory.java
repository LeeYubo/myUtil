package com.lyb.model.factory.abstractfactory;

public class AMDComputerFactory implements ComputerFactory{

	@Override
	public CPU createCPU() {
		CPU cpu = new AMDCPU(938);
		return cpu;
	}

	@Override
	public MainBoard createMainBoard() {
		MainBoard mainBoard = new AMDMainBoard(938);
		return mainBoard;
	}

}
