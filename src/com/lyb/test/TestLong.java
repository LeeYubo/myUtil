package com.lyb.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestLong {

	public static void main(String[] args) {
		List<String> iccidList = new ArrayList<>();
		
		String startIccid = "50000000000000000011";
		String endIccid = "60000000000000000120";
		String particleIccid = "1";
		
		BigDecimal start = new BigDecimal(startIccid);
		BigDecimal end = new BigDecimal(endIccid);
		BigDecimal particle = new BigDecimal(particleIccid);
		
		if(end.compareTo(start)==0){
			iccidList.add(startIccid);
		}else{
			iccidList.add(startIccid);
			BigDecimal temp = start;
			while(end.compareTo(temp)>0){
				temp = temp.add(particle);
				iccidList.add(temp.toString());
			}
		}
		
		for(String iccid : iccidList){
			System.out.println(iccid);
		}
	}
}
