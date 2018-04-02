package com.lyb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import oracle.net.aso.i;

public class TestAny {
	
	public static void main(String[] args) {

//		System.out.println(TestAb.test());
		
		String key = "just a test string";
		String key2 = "just a test string";
		System.out.println("key hashCode 001 = "+key.hashCode());
		System.out.println("key hashCode 002 = "+key2.hashCode());
		
		System.out.println("Long.MAX_VALUE = "+Long.MAX_VALUE);
		
		
//		Integer [] aArrays = new Integer[10];
//		for(int i=0;i<10;i++){
//			aArrays[i] = i;
//		}
//		System.out.println(Arrays.toString(aArrays));
		
//		String aString = "";
		
//		Integer a = 829;
//		Double b  = null;
//		b = a.doubleValue()/1000;
//		System.out.println(b);
		
//		Integer a = 12800;
//		Integer b = 12800;
//		boolean result = a==b;
//		boolean result = Integer.valueOf(a).equals(Integer.valueOf(b));
//		boolean result = a.equals(b);
//		
//		if(a.compareTo(b)==0){
//			System.out.println("a == b;"+result);
//		}
		
		/*List<Integer> listAll = new ArrayList<Integer>();
		List<Integer> listChild = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			listAll.add(i);
		}
		listChild = listAll.subList(2, 5);
		for(Integer j : listChild){
			System.out.println("j = "+j);
		}
		System.out.println("\n");*/
		
		/*System.out.println(Integer.MIN_VALUE);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1300001", "1300001");
		map.put("1300002", "1300002");
		map.put("1300003", "1300003");
		map.put("1300004", "1300004");
		for(int i=0;i<10;i++){
			map.put("130000"+i, "130001"+i);
		}
		Object s[] = map.keySet().toArray();
		for(int i = 0; i < map.size(); i++) {
			System.out.println(map.get(s[i]));
		}
		System.out.println("\n\n\n\n");*/
		
//		String test = "1|2|3|4|5||";
//		String [] result = test.split("\\|",-1);
//		System.out.println("数组长度 = "+result.length);
//		for(int i=0;i<result.length;i++){
//			System.out.println(i+" = "+result[i]);
//		}
		
		
//		List<String> list = new ArrayList<String>();
//		List<Integer> list2 = null;
//		for(String string : list){
//			System.out.println("string = "+string);
//		}
//		System.out.println("---------");
//		for(Integer integer : list2){
//			System.out.println("string = "+integer);
//		}
		
//		A1 = (USU+ TAIL_COUNTER+UNIT-1)/UNIT;
//		A2 = (TAIL_COUNTER+UNIT-1)/UNIT;
//		FEE  = (A1- A2) * PRICE.
//
//		比如: T1：5分钟，300秒的费用计算如下.
//		A1 = (300+0+60-1)/60 = 5
//		A2 = (0+60-1)/60 = 0
//		Fee = (5- 0) * 200 = 1000厘.
		
//		int unit = 60;
//		float usu = 0;
//		float tail_counter = 0;
//		float price = 0;
//		
//		float a1 = 0;
//		float a2 = 0;
//		float fee = 0;
//		
//		usu=1*60;
//		price = 100;
//		
//		a1 = (usu+ tail_counter+unit-1)/unit;
//		a2 = (tail_counter+unit-1)/unit;
//		fee = (a1 - a2)*price;
//		
//		System.out.println("fee = "+fee);
		
//		System.out.println(System.currentTimeMillis());
//		System.out.println(Float.MAX_VALUE);
//		System.out.println(Float.MIN_VALUE);
//		float f = (float) 123456789012345678901234567890.0;
//		System.out.println(f);
		
		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(30);
//		list.add(15);
//		list.add(-10);
//		list.add(2);
//		list.add(20);
//		list.add(3);
		
/*		list.add(-30);
		list.add(-15);
		list.add(-120);
		list.add(-100);
		list.add(0);
		list.add(-3);
		
		//求30 对应的i编号1 
		int value = 0;
		int num = -1;
		int temp = 0;
		int countPlus = 0;
		int countMinus = 0;
		boolean isExistAdd = false;
		for(int i=0;i<list.size();i++){
			value = list.get(i);
			if(value==0){
				temp = value;
				num = i;
				break;
			}else if(value>0){
				isExistAdd = true;
				if(countPlus==0){
					temp = value;
					num = i;
					countPlus++;
				}else if(value<temp){
					temp = value;
					num = i;
				}
			}else if(value<0){
				if(!isExistAdd){
					if(countMinus==0){
						temp = value;
						num = i;
						countMinus++;
					}else if(value<temp){
						temp = value;
						num = i;
					}
				}
			}
		}
		System.out.println("temp = "+temp);
		System.out.println("num = "+num);*/
		
//		String validUnits = "#3475034";
//		System.out.println(validUnits.indexOf("#"));
//		String temp = validUnits.substring(1, validUnits.length());
//		System.out.println("temp = "+temp);
//		long localFlowCount = Long.valueOf(temp);
//		System.out.println("localFlowCount = "+localFlowCount);
//		
//		System.out.println(" Integer.MAX_VALUE = "+Integer.MAX_VALUE);
//		int a = 2147483647;
//		int b = 2147483647;
//		System.out.println(a);
//		long c = a+b;
//		System.out.println(a);
//		b = a;
		
//		String temp = "flag2";
//		switch (temp){
//		case "flag":
//			System.out.println("999999999");
//			break;
//		case "tttt":
//			System.out.println("999999999");
//			break;
//		default:
//			System.out.println("-------------");
//			break;
//		}
		
//		Date firstCallTime = null;
//		SimpleDateFormat spf = new SimpleDateFormat("yyyyMM");
//		System.out.println(spf.format(new Date()).equals(spf.format(firstCallTime)));
		
//		getLocalUsed("150-140");
		
		
//		java.util.Date date = new java.util.Date();
//		System.out.println(date);
//		Integer int1 = 10000;
//		Integer int2 = 10000;
//	
//		if(int1.equals(int2)){
//			System.out.println(" int1 与 int2 相等！");
//		}else{
//			System.out.println(" int1 与 int2 不相等！");
//		}
		
		/*for(int i=0;i<80;i++){
			System.out.println(i);
		}*/
		
	/*	if(int1.intValue()==int2.intValue()){
			System.out.println(" int1 与 int2 相等！");
		}else{
			System.out.println(" int1 与 int2 不相等！");
		}
		*/
		
		
//		List<String> iccidList = new ArrayList<String>();
//		iccidList.add("89860114840100103763");
//		iccidList.add("89860114840100100008");
//		iccidList.add("89860114840100100026");
//		iccidList.add("89860114840100104797");
//		iccidList.add("89860114850100100001");
//		Collections.sort(iccidList);
//		for(String iccid : iccidList){
//			System.out.println("iccid = "+iccid);
//		}
		
//		try {
//			String string = "20160829000000";
//			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
//			Date date = format.parse(string);
//			System.out.println("date = "+date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		/*String desc = "员工{0}没有卡号{1}的操作权限";
		String [] values = new String [] {"ali1","89860114840100000002"};
		if(values.length>0){
			for(int i=0;i<values.length;i++){
				desc = desc.replaceAll("\\{"+i+"\\}", "["+values[i]+"]");
			}
		}
		System.out.println("desc = "+desc);*/
		
//		try {
//			System.out.println(DateUtils.parseDate("20160909101010", "yyyyMMddhhmmss"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Long.MAX_VALUE);
	}

	
//	public Integer test(String param, Integer param2){
//		System.out.println(" param2 start = "+param2);
//		if("1".equals(param)){
//			param2 += 10;
//			System.out.println("param2 = "+param2);
////			return 1;
//		}else{
//			return 2;
//		}
//		System.out.println(" param2 = "+param2);
//		return 1;
////		return null;
//	}
//	
	
	
	/*public static Long getLocalUsed(String validUnit) {
		System.out.println(" 传入参数 = "+validUnit);
		Long result = 0L;
		int position = validUnit.indexOf("-");
		String prefix = "";
		String suffix = "";
		if(position>0){
			prefix = validUnit.substring(0, position);
			suffix = validUnit.substring(position+1, validUnit.length());
			result = Long.valueOf(prefix) - Long.valueOf(suffix);
		}else{
			System.out.println(" --------------- 取UV公式异常 --------------- "+validUnit);
		}
		
		return result;
	}*/
	
}
