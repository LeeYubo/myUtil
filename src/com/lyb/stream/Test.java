package com.lyb.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void test2(){
		try {
			FileInputStream fileInputStream = new FileInputStream("d:/A2.txt");
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			byte [] byteArray = new byte[1024];
			while(bufferedInputStream.read(byteArray,0,1024)!=-1){
				for(int i=0;i<byteArray.length;i++){
					System.out.print(byteArray[i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyFile(){
		try {
			FileInputStream fileInputStream = new FileInputStream("d:/FTP.java");
			FileOutputStream fileOutputStream = new FileOutputStream("d:/FTP_BK.java");
			
			byte [] byteArray = new byte[1024];
			int length = 0;
			while((length = fileInputStream.read(byteArray))!=-1){
				fileOutputStream.write(byteArray,0,length);
			}
			fileInputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		copyFile();
		
		
		//节点流FileOutputStream直接以A.txt作为数据源操作
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\A.txt");
        byte [] byteArray = new byte[10];
        for(int i=0;i<byteArray.length;i++){
        	byteArray[i] = (byte) 1;
        }
//        System.out.println(byteArray[1]+" = hhh");
        byte b = 1;
        char c = '中';
        //向输出流里写入一个值为 b 的字节。需要注意的是，实际写入的是 int 类型 b 的低8位，其余的 24 位被忽略。
//        System.out.println(c);
//        fileOutputStream.write(b);
//        fileOutputStream.flush();
//        fileOutputStream.close();
        
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeChar('c');
        dataOutputStream.writeBoolean(true);
        dataOutputStream.close();
        
        FileWriter fileWriter = new FileWriter("d:\\A2.txt");
        fileWriter.write("你好啊！");
        fileWriter.flush();
        fileWriter.close();
        
//		FileInputStream fileInputStream = new FileInputStream("d:\\A.txt");
//		byte [] byteArray = new byte[100];
//		while(fileInputStream.read(byteArray)!=-1){
//			for(int i=0;i<byteArray.length;i++){
//				System.out.print(byteArray[i]);
//	        }
//		}
		
//        // 过滤流BufferedOutputStream进一步装饰节点流，提供缓冲写
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//        // 过滤流DataOutputStream进一步装饰过滤流，使其提供基本数据类型的写
//        DataOutputStream out = new DataOutputStream(bufferedOutputStream);
//        out.writeInt(3);
//        out.writeBoolean(true);
//        out.writeChar('q');
//        out.flush();
//        out.close();
        // 此处输入节点流，过滤流正好跟上边输出对应，读者可举一反三
//        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("A.txt")));
//        System.out.println(in.readInt());
//        System.out.println(in.readBoolean());
//        in.close();
}
}
