package com.lyb.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lyb.log.Log;

public class StaticTest {

	private String HostIP = "";
	private String HostName = "";
	
	StaticTest(String ip,String name){
		this.HostIP = ip;
		this.HostName = name;
	}
	
	public String getHostIP() {
		return HostIP;
	}
	public void setHostIP(String hostIP) {
		HostIP = hostIP;
	}
	public String getHostName() {
		return HostName;
	}
	public void setHostName(String hostName) {
		HostName = hostName;
	}
	
	public void show(){
		System.out.println("hostIP = "+getHostIP());
	}
	
	public static void main(String[] args) {
//		StaticTest test1 = new StaticTest("127.0.0.1","yubo Lee");
//		StaticTest test2 = new StaticTest("192.168.44.62","admin");
		
//		test1.show();
//		test2.show();
//		test1.show();
		
//		Log.getLogger().info("----------- start 111 -------");
//		Set<String> set1 = new HashSet<String>();
//		for(int a=0;a<100000;a++){
//			if(a%1000==0){
//				set1.add("liyubo_"+a);
//			}
//			set1.add("set1"+a);
//		}
		
//		Set<String> set2 = new HashSet<String>();
//		for(int b=0;b<100000;b++){
//			if(b%1000==0){
//				set2.add("liyubo_"+b);
//			}
//			set2.add("set2"+b);
//		}
//		
//		Iterator<String> it_2 = set2.iterator();
//		
//		Log.getLogger().info("----------- start -------");
//		while(it_2.hasNext()){
//			String test = it_2.next();
//			
//			if(set1.contains(test)){
//				System.out.println("-------"+test);
//			}
//		}
//		Log.getLogger().info("----------- stop -------");
		
		System.out.println("args length = "+args.length);
		
		String fileName = "2015011011.BIL";
		String tempName = "";
		System.out.println(fileName.length());
		if(fileName.length()>=8){
			tempName = fileName.substring(0, 8);
		}
		
		System.out.println(tempName);
	}

}


