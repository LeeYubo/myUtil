package com.lyb.model.factory.factoryfunction;

public class ExportHtmlSpecialFile implements InterfaceExportFile {

	@Override
	public String export() {
		String result = "导出HTML格式特殊类型的财务报表！";
		return result;
	}
}
