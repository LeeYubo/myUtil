package com.lyb.file;

import java.io.File;
import java.util.ArrayList;

public class FileTest {
	private static ArrayList<String> filelist = new ArrayList<String>();

	public static void main(String[] args) throws Exception {

		String filePath = "F://成卡文件";
		
		getFiles(filePath);
//		changeFileName("C://Users//Yubo Lee//Desktop//HLR与号段文件//HLR与号段关系文件","20170424","20170426");
	}

	/*
	 * 通过递归得到某一路径下所有的目录及其文件
	 */
	static void getFiles(String filePath) {
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				/*
				 * 递归调用
				 */
				getFiles(file.getAbsolutePath());
				filelist.add(file.getAbsolutePath());
				System.out.println("显示" + filePath + "下所有子目录及其文件" + file.getAbsolutePath());
			} else {
				System.out.println("显示" + filePath + "下所有子目录" + file.getAbsolutePath());
			}
		}
	}
	
	
	/*
	 * 通过递归得到某一路径下所有的目录及其文件
	 */
	static void changeFileName(String filePath,String source, String target) {
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			if(file.isFile()){
				String fileName = file.getName();
				fileName = fileName.replaceAll(source, target);
				File newFile = new File(file.getParent()+File.separator+fileName);
				if(file.renameTo(newFile)){
					System.out.println("文件名称修改成功！");
				}
			}
		}
	}
}