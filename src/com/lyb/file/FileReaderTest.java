package com.lyb.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderTest {

	public static void main(String[] args) {
		File file = new File("G:\\lunma.txt");
		
		try {
//			FileReader fileReader = new FileReader(file);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader buffer = new BufferedReader(isr);
			for (String line = buffer.readLine(); line != null; line = buffer.readLine()) {
				System.out.println("line = "+line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

//		解决办法：
//		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
//		BufferedReader read = new BufferedReader(isr);
	}
}
