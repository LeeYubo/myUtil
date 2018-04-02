package com.lyb.stream;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamTest {
	
	FileInputStream is = null;
	FileOutputStream os = null;
	
	InputStreamReader inputStreamReader = null;
	OutputStreamWriter outputStreamWriter = null;
	
	int ch;
	/**
	 * 从控制台输入内容，以回车结束，将文件写入到文件
	 * */
	public void ConsoleToFile(){
		try {
			is = new FileInputStream(FileDescriptor.in);
			//FileOutputStream构造方法的第二个参数如果为true，表示向文件中追加内容,如果为false则表示替换原来的文件内容
			os = new FileOutputStream("test.txt",true);
			
			System.out.println("请输入一个字符：");
			while((ch=is.read())!='\r'){
				os.write(ch);
			}
			is.close();
			os.close();
			System.out.println("写入完成！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 读取一个文件，将内容打印到控制台
	 * */
	public void ReadFileToConsole(){
		try {
			is = new FileInputStream("test.txt");
			os = new FileOutputStream(FileDescriptor.out);
			
			System.out.println("请一个指定的文件：");
			while((ch=is.read())!=-1){
				os.write(ch);
			}
			is.close();
			System.out.println("读文件完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 复制一个文件到另一个文件
	 * */
	public void CopyFile(){
		try {
			is = new FileInputStream("test.txt");
			os = new FileOutputStream("second.txt");
			
			while((ch=is.read())!=-1){
				os.write(ch);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 字符流，从键盘输入，打印到控制台。
	 * */
	public void ConsoleToConsole(){
		inputStreamReader = new InputStreamReader(System.in);
		outputStreamWriter = new OutputStreamWriter(System.out);
		
		try {
			System.out.println("请输入一行字符串，并以回车结束！");
			while((ch=inputStreamReader.read())!='\r'){
				outputStreamWriter.write(ch);
			}
			inputStreamReader.close();
			outputStreamWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 字符流复制文件
	 * 
	 * */
	public void CopyFileChar(){
		
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream("test.txt"));
			outputStreamWriter = new OutputStreamWriter(new FileOutputStream("third.txt"));
		} catch (FileNotFoundException e1) {
			System.out.println("文件未找到！");
		}
		
		try {
			System.out.println("开始复制文件！");
			while((ch=inputStreamReader.read())!=-1){
				outputStreamWriter.write(ch);
			}
			inputStreamReader.close();
			outputStreamWriter.close();
			System.out.println("复制文件结束！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 读取一个文件，将内容放进Byte数组
	 * */
	public void ReadFileToByte(){
		try {
			is = new FileInputStream("test.txt");
			os = new FileOutputStream(FileDescriptor.out);
			
			System.out.println("请一个指定的文件：");
			int len = -1;
			byte[] b = new byte[10];
            while ((len = is.read(b)) != -1) {
                    os.write(b, 0, len);
            }
			is.close();
			System.out.println("读文件完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StreamTest streamTest = new StreamTest();
		
		//从控制台输入内容，以回车结束，将文件写入到文件
		//streamTest.ConsoleToFile();
		
		//读一个文件，将内容打印到屏幕上。
		//streamTest.ReadFileToConsole();
		
		//复制一个文件的内容到另一个文件
		streamTest.CopyFile();
		
		//字符流操作：键盘输入，并打印到控制台
		//streamTest.ConsoleToConsole();
		
		//采用字符流方式 复制一个文件的内容到另一个文件
		//streamTest.CopyFileChar();
		
//		streamTest.ReadFileToByte();
	}
	
}
