package com.lyb.model.factory.abstractfactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String type = "Intel";
		ComputerEngineer engineer = new ComputerEngineer();
		engineer.createComputer(type);
		engineer.cpu.calculate();
		engineer.mainboard.initMainBoard();
	}

}
