package com.lyb.base64;

import java.io.IOException;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Test {

	public static void main(String[] args) {
		String sourceString = "Hello Base64！";
		System.out.println("sourceString = "+sourceString);
		// 第一种方式
		System.out.println("第二种方式");
		String encodeResult = Base64.encode(sourceString.getBytes());
		System.out.println("Base64编码之后的结果:"+encodeResult);
		System.out.println("Base64解码之后的结果:"+new String(Base64.decode(encodeResult)));
		
		// 第二种方式
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String encodeResult2 = base64Encoder.encode(sourceString.getBytes());
		System.out.println("第二种方式");
		System.out.println("Base64编码之后的结果:"+encodeResult2);
		BASE64Decoder base64Decoder = new BASE64Decoder();
		try {
			System.out.println("Base64解码之后的结果:"+new String(base64Decoder.decodeBuffer(encodeResult2)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
