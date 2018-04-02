package com.lyb.model.factory.abstractfactory;

public class ComputerEngineer {

	public CPU cpu = null;
	public MainBoard mainboard = null;
	
	public void createComputer(String computerType){
		if("AMD".equals(computerType)){
			ComputerFactory computerFactory = new AMDComputerFactory();
			this.cpu = computerFactory.createCPU();
			this.mainboard = computerFactory.createMainBoard();
		}
		if("Intel".equals(computerType)){
			ComputerFactory computerFactory = new IntelComputerFactory();
			this.cpu = computerFactory.createCPU();
			this.mainboard = computerFactory.createMainBoard();
		}
	}
}
