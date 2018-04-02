package com.lyb.file.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class NioService {
	
	
	public static void main(String[] args) {
		String sourcePath = "E:\\Temp\\Kafka.jar";
		String targetPath = "E:\\Temp\\Kafka_copy.jar";
		
		NioService nioService = new NioService();
		nioService.copyFileByNio(sourcePath, targetPath);
		nioService.copyFileByBio(sourcePath, targetPath);
	}

	public void copyFileByNio(String sourceFile, String targetFile){
		Long start = System.currentTimeMillis();
        // Create channel on the source
        FileChannel srcChannel = null;
        FileChannel dstChannel = null;
		try {
			srcChannel = new FileInputStream(sourceFile).getChannel();
			dstChannel = new FileOutputStream(targetFile).getChannel();
	        dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
	        srcChannel.close();
	        dstChannel.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dstChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				srcChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Long stop = System.currentTimeMillis();
		System.out.println("NIO耗时："+(stop-start)+" ms");
	}
	
	
	public void copyFileByBio(String fileSource, String fileTarget){
		Long start = System.currentTimeMillis();
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		byte [] byteContent = null;
		try {
			inputStream = new FileInputStream(fileSource);
			byteContent = new byte[(int) fileSource.length()];
			inputStream.read(byteContent);
			outputStream = new FileOutputStream(fileTarget);
			outputStream.write(byteContent);
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
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Long stop = System.currentTimeMillis();
		System.out.println("BIO耗时："+(stop-start)+" ms");
	}
}
