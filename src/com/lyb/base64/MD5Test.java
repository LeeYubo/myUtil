package com.lyb.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {

	public static void main(String[] args) {
//		String message = "Hello MD5!ewtsdfsdfms;dfjsndf sdlsd;nsdfsdsdvsd ";
//		try {
//			MessageDigest md5 = MessageDigest.getInstance("MD5");
//			byte [] bytes = md5.digest(message.getBytes());
//			System.out.println("bytes length = "+bytes.length);
//			System.out.println("MD5哈希结果："+bytesToHexString(bytes));
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		String file1 = "E:\\temp\\gitpath\\readme11.zip";
//		String file2 = "E:\\temp\\gitpath\\readme22.zip";
//		String file3 = "E:\\temp\\gitpath\\readme33.zip";
//		System.out.println("fileName ("+file1+") SHA-1 result:"+getFileMD5(file1));
//		System.out.println("fileName ("+file3+") SHA-1 result:"+getFileMD5(file3));
//		System.out.println("fileName ("+file2+") SHA-1 result:"+getFileMD5(file2));
		
		System.out.println("fileName (E:\\mine\\bird.png) SHA-1 result:"+getFileMD5("E:\\mine\\bird.png"));
	}
	
	
	public static String getFileMD5(String filePath){
		File file = new File(filePath);
		FileInputStream inputStream = null;
		byte[] body = null;
		try {
			inputStream = new FileInputStream(file);
			body = new byte[(int) file.length()];
			inputStream.read(body);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String result = null;
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte [] md5Bytes = md5.digest(body);
			result = bytesToHexString(md5Bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String bytesToHexString(byte[] src){  
	    StringBuilder stringBuilder = new StringBuilder("");  
	    if (src == null || src.length <= 0) {  
	        return null;  
	    }  
	    for (int i = 0; i < src.length; i++) {  
	        int v = src[i] & 0xFF;  
	        String hv = Integer.toHexString(v);  
	        if (hv.length() < 2) {  
	            stringBuilder.append(0);  
	        }  
	        stringBuilder.append(hv);  
	    }  
	    return stringBuilder.toString();  
	}  
}
