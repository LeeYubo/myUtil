package com.lyb.file;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class FileOper {

	File 	dirFresh = null;
	File [] allFiles = null;
	
	String 	fileName = null;
	String 	fileType = null;
	String 	fileDate = null;
	Long 	fileSize = null;
	
	/**
	 * 获取指定目录下的文件盒目录，类似于DOS下的dir命令
	 * 打印类型（文件还是目录）、时间、大小、文件名称
	 * */
	public void Dir(File dir){
		//如果指定目录为空，则以当前目录为默认目录
		if(dir==null){
			dirFresh = new File(".");
		} else {
			dirFresh = dir;
		}
		
		allFiles = dirFresh.listFiles();
		System.out.printf("%10s  %30s %12s     %s\n","类型","日期","大小","名称");
		for(int i=0; i<allFiles.length; i++){
			fileName = allFiles[i].getName();
			if(allFiles[i].isFile()){
				//文件
				fileType = "file";
				fileSize = allFiles[i].length();
			}else{
				//目录
				fileType = "dir";
				fileSize = 0L;
			}
			fileDate = FileOper.dealFileDate(allFiles[i].lastModified());
			System.out.printf("%10s%30s%12s    %s\n",fileType,fileDate,fileSize,fileName);
		}
	}
	
	/**
	 * 对时间格式进行处理
	 * */
	public static String dealFileDate(Long fileDate){
		StringBuffer fileDateStr = new StringBuffer("");
		Date date = null;
		String yearStr, monthStr, dayStr, hourStr, minuteStr, secondStr;
		if(fileDate!=null && fileDate>0){
			date = new Date(fileDate);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			yearStr = calendar.get(Calendar.YEAR)+"";
			monthStr = ((calendar.get(Calendar.MONTH))+1)+"";
			dayStr = calendar.get(Calendar.DAY_OF_MONTH)+"";
			hourStr = calendar.get(Calendar.HOUR_OF_DAY)+"";
			minuteStr = calendar.get(Calendar.MINUTE)+"";
			secondStr = calendar.get(Calendar.SECOND)+"";
			
			
			//下面的方法仍然可以使用，但是官方不推荐
			/*
			yearStr = String.valueOf(date.getYear()+1900);
			monthStr = String.valueOf(date.getMonth()+1);
			dayStr = String.valueOf(date.getDate());
			hourStr = String.valueOf(date.getHours());
			minuteStr = String.valueOf(date.getMinutes());
			secondStr = String.valueOf(date.getSeconds());
			*/
			
			fileDateStr.append(yearStr).append("-")
				.append(leftPad(2,monthStr,'0')).append("-")
				.append(leftPad(2,dayStr,'0')).append(" ")
				.append(leftPad(2,hourStr,'0')).append(":")
				.append(leftPad(2,minuteStr,'0')).append(":")
				.append(leftPad(2,secondStr,'0'));
			
			return fileDateStr.toString();
		}	
		return null;
	}
	
	/**
	 * 根据指定长度，指定要填充的字符，对指定的字符串进行填充
	 * @author Administrator
	 * @parame length		字符串拼接之后的总长度
	 * @parame strSource	传入的源字符串
	 * @parame charPad		用于填充的字符串
	 * */
	public static String leftPad(int length, String strSource, char charPad){
		StringBuffer strPad = new StringBuffer();
		if(strSource.length()<length){
			for(int i=0; i<length-strSource.length(); i++){
				strPad.append(charPad);
			}
			strPad.append(strSource);
			return strPad.toString();
		}
		return strSource;
	}
	
	public static void main(String[] args) {
		FileOper fileOper = new FileOper();
		File dir = new File("E:/2013/");
		fileOper.Dir(dir);
	}
}
