package com.lyb.model.factory.abstractfactory;

public class IntelComputerFactory implements ComputerFactory {

	@Override
	public CPU createCPU() {
		CPU cpu = new IntelCPU(755);
		return cpu;
	}

	@Override
	public MainBoard createMainBoard() {
		MainBoard mainBoard = new IntelMainBoard(755);
		return mainBoard;
	}
}
