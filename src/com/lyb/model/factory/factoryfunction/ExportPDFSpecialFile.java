package com.lyb.model.factory.factoryfunction;

public class ExportPDFSpecialFile implements InterfaceExportFile {

	@Override
	public String export() {
		String result = "导出PDF格式特殊类型的财务报表！";
		return result;
	}

}
