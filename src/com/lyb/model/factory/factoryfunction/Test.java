package com.lyb.model.factory.factoryfunction;

public class Test {

	public static void main(String[] args) {
		
		InterfaceFactory factory = new PDFExport();
		String dataType = "stand";
		InterfaceExportFile exportFile = factory.getExportManage(dataType);
		
		System.out.println(exportFile.export());
	}
}
