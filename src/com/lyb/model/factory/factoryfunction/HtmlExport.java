package com.lyb.model.factory.factoryfunction;

public class HtmlExport implements InterfaceFactory {

	HtmlExport(){
		System.out.println("导出HTML类被调用！");
	}
	
	@Override
	public InterfaceExportFile getExportManage(String dataType) {
		if("stand".equals(dataType)){
			return new ExportHtmlStandFile();
		}else if("special".equals(dataType)){
			return new ExportHtmlSpecialFile();
		}else{
			return null;
		}
	}
}
