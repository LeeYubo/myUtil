package com.lyb.model.factory.factoryfunction;

public class PDFExport implements InterfaceFactory {

	PDFExport(){
		System.out.println("导出PDF类被调用！");
	}
	
	@Override
	public InterfaceExportFile getExportManage(String dataType) {
		if("stand".equals(dataType)){
			return new ExportPDFStandFile();
		}else if("special".equals(dataType)){
			return new ExportPDFSpecialFile();
		}else{
			return null;
		}
	}

}
