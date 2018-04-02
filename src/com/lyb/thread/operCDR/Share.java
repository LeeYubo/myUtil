/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lyb.thread.operCDR;

import java.io.*;
import java.util.Vector;

import com.lyb.log.Log;

public class Share {
	
	/**
	 * @author Yubo Lee
	 * 
	 * */
	public static byte [] getCDRArray(String filepath){
		File srcFile = new File(filepath);
		BufferedInputStream in = null;
		ByteArrayOutputStream out = null;
		byte[] content = null;
		try {
			in = new BufferedInputStream(new FileInputStream(srcFile));
			out = new ByteArrayOutputStream(1024);

			int len = -1;
			byte[] b = new byte[1024];
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			content = out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭输入流和输出流
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
	
	
	public String HextoString(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
						i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				Log.getLogger().error(" --- ",e);
			}
		}
		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			Log.getLogger().error(" --- ",e1);
		}
		return s;
	}
	
	/**
	 * @author Yubo Lee
	 * 
	 * */
	public static String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
	
	
	public static String Lpad(String value, String Ch, int len) {
		int templen;
		templen = len - value.length();
		return FillChar(templen, Ch) + value;
	}
	
	public static String FillChar(int count, String value) {
		String s = "";
		for (int i = 1; i <= count; i++) {
			s = s + value;
		}
		return s;
	}
	
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();

		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}
	
	public static Vector<byte[]> getArray(byte[] allBytes, int cdrLength){
		Vector<byte[]> vector = new Vector<byte[]>();
		byte [] temp = null;
		if((allBytes.length % cdrLength) != 0){
			System.out.println("话单异常！");
		}
		int count = allBytes.length / cdrLength;
		int start = 0;
		for(int i=0; i<count; i++){
			temp = new byte[cdrLength];
			System.arraycopy(allBytes,start,temp,0,cdrLength);
			start += cdrLength;
			vector.add(temp);
		}
		return vector;
	}
	
	/**
     * 返回按一定长度的右对齐串
     *
     * @return
     */
    public static String FunResultImportStr(String SInputStr, int Len, String SAddLorR) {
		String Sstr;
		String Result;
		Sstr = SInputStr.trim();
		if (Sstr.length() > Len) {
			Result = Sstr.substring(0, Len);
		} else if (Sstr.length() == Len) {
			Result = Sstr;
		} else if (SAddLorR.toUpperCase() == "R") {
			Result = "                              ".substring(0, Len
					- Sstr.length())
					+ Sstr;
		} else {
			Result = Sstr
					+ "                              ".substring(0, Len
							- Sstr.length());
		}
		return Result;
	}
}
