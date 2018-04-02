package com.lyb.model.factory.abstractfactory;

public interface ComputerFactory {

	public CPU createCPU();
	
	public MainBoard createMainBoard();
}
