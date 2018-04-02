package com.lyb.model.factory.factoryfunction;

public class ExportHtmlStandFile implements InterfaceExportFile {

	@Override
	public String export() {
		String result = "导出HTML格式标准类型的财务报表！";
		return result;
	}

}
