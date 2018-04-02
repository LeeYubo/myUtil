package com.lyb.thread.operCDR;

import com.lyb.log.Log;

public class Analysis extends Thread {

	private String hexCDR = "";
	
	Analysis(String hexCDR){
		this.hexCDR = hexCDR;
	}
	
	@Override
	public void run() {
		analys();
	}

	
	public void analys(){
		String temp = "";
		String caller = "";
		String callee = "";
		String startTime = "";
		String duration = "";
		int end = 0;
		
		temp = hexCDR.substring(26*2, 36*2);
		end = temp.indexOf('F');
		if(end>0){
			caller = temp.substring(0, temp.indexOf('F'));
		}else{
			caller = temp.substring(0, 20);
		}
		
		temp = hexCDR.substring(38*2, 48*2);
		end = temp.indexOf('F');
		if(end>0){
			callee = temp.substring(0, temp.indexOf('F'));
		}else{
			callee = temp.substring(0, 20);
		}
		
		temp = hexCDR.substring(8*2, 14*2);
		String year = Integer.parseInt(temp.substring(0, 2), 16)+2000+"";
		String month = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(2, 4), 16)), "0", 2);
		String day = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(4, 6), 16)), "0", 2);
		String hour = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(6, 8), 16)), "0", 2);
		String minute = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(8, 10), 16)), "0", 2);
		String second = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(10, 12), 16)), "0", 2);
		startTime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
		
		temp = hexCDR.substring(14*2, 20*2);
		year = Integer.parseInt(temp.substring(0, 2), 16)+2000+"";
		month = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(2, 4), 16)), "0", 2);
		day = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(4, 6), 16)), "0", 2);
		hour = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(6, 8), 16)), "0", 2);
		minute = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(8, 10), 16)), "0", 2);
		second = Share.Lpad(Integer.toString(Integer.parseInt(temp.substring(10, 12), 16)), "0", 2);
		duration = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
		
		temp = hexCDR.substring(20*2, 24*2);
		byte[] b = Share.hexStringToByte(temp.toString());
        long duration1 = ((0x000000ff & b[3]) << 24) & 0xff000000;
        long duration2 = ((0x000000ff & b[2]) << 16) & 0x00ff0000;
        long duration3 = ((0x000000ff & b[1]) << 8) & 0x0000ff00;
        long duration4 = 0x000000ff & b[0];
        long durationL = duration1 | duration2 | duration3 | duration4;
        duration = durationL + "";
		
        
        StringBuffer sb = new StringBuffer();
		sb.append(Share.FunResultImportStr(caller, 20, "R")).append(" ")
		.append(Share.FunResultImportStr(startTime, 20, "R")).append(" ")
		.append(Share.FunResultImportStr(duration+"", 8, "R")).append(" ")
		.append(Share.FunResultImportStr(" ", 12, "R")).append(" ")
		.append(Share.FunResultImportStr(callee, 20, "L")).append(" ");
        
		Log.getLogger().info(sb.toString());
		FileOper.vectoranalysised.add(sb.toString());
	}
}
