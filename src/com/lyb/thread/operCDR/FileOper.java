package com.lyb.thread.operCDR;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lyb.log.Log;

public class FileOper{

	public static final int CDR_LANGTH = 118;
	public static List<String> vectoranalysised = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		String filepath = "E:/计费系统/HDFJ/test/billFile/CC08/20140618.BIL";
		byte [] allbytes = Share.getCDRArray(filepath);
		Vector<byte[]> vector = Share.getArray(allbytes, FileOper.CDR_LANGTH);
		System.out.println(vector.size());
		Iterator<byte[]> iterator = vector.iterator();
		
		
		Log.getLogger().info("--------- start ---------");
		ExecutorService executor = Executors.newFixedThreadPool(20);
		while(iterator.hasNext()){
			byte [] temp = iterator.next();
			String strTemp = Share.bytesToHexString(temp);
			Analysis analysis1 = new Analysis(strTemp);
			executor.execute(analysis1);
		}
		executor.shutdown();
		Log.getLogger().info("--------- end ---------");
//		Iterator<String> iterator2 = vectoranalysised.iterator();
//		while(iterator2.hasNext()){
//			Log.getLogger().info(iterator2.next());
//		}
	}
}
