package com.lyb.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonUtil {

	/**
	 * @author Administrator
	 * 使用正则表达式，将多个空格替换成一个
	 * @param stringFormer：原字符串
	 * @return String：返回的处理结果
	 * */
	public static String replaceToOne(String stringFormer){
		String result = "";
		result = stringFormer.replaceAll("\\s{1,}"," ");
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//使用正则表达式，将多个空格替换成一个
		//System.out.println(replaceToOne("li   yu    bo"));
		
		
//		String test = "DOCUMENT_ID,DOCUMENT_NO,COMPANY_NAME,IDENTIFY_CODE,ADDRESS_PHONE,BANKAC_COUNT,REVIEW,REMITTEE,REMARK,EXPORTCODE,CREATETIME";
//		
//		test = test.toLowerCase();
//		System.out.println(test);
		
		List<String> list = new ArrayList<>();
		list.add("3");
		list.add("1000");
		list.add("2");
		list.add("5");
		list.add("67");
		list.add("11");
		list.add("10");
		list.add("90");
		list.add("101");
		for(String str : list){
			System.out.println(str);
		}
		System.out.println(" ------------------------------ ");
		Collections.reverse(list);
//		Collections.sort(list);
		for(String str : list){
			System.out.println(str);
		}
	}

}
