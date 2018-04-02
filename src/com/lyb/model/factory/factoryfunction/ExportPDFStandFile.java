package com.lyb.model.factory.factoryfunction;

public class ExportPDFStandFile implements InterfaceExportFile {

	@Override
	public String export() {
		String result = "导出PDF格式标准类型的财务报表！";
		return result;
	}

}
