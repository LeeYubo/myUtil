package com.lyb.security;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * AES加密类
 * 
 * @author liuyan
 */
public final class AESUtil {

	//private final static Logger logger = Logger.getLogger(AESUtil.class);

	// 密钥位数
	private final static int keyNum = 128;

	// 加密算法类型
	private final static String enType = "AES";

	// 编码类型
	private final static String encodeType = "utf-8";

	// 固定的那个密钥，可以加载的时候替换之
	private volatile static String keycontent = "tsdtstar20121212TSTARTSD";

	// 加密器
	private static Cipher cipherEn = null;

	// 加密器
	private static Cipher cipherDe = null;

	// 密钥生成器
	private static KeyGenerator kgen = null;

	// 密钥操作对象
	private static SecretKey secretKey = null;
	private static byte[] enCodeFormat = null;
	private static SecretKeySpec key = null;
	static {
		// 初始化加密的一些全局的环境变量
		try {
			
			// 密钥生成器
			kgen = KeyGenerator.getInstance(enType);
			
			 //防止linux下 随机生成key
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
            secureRandom.setSeed(keycontent.getBytes());  
			// 根据密钥初始化密钥生成器
			kgen.init(keyNum, secureRandom);

			// 密文操作对象
			cipherEn = Cipher.getInstance(enType);

			// 密文操作对象
			cipherDe = Cipher.getInstance(enType);

			secretKey = kgen.generateKey();

			enCodeFormat = secretKey.getEncoded();
			
			//System.out.println("key是["+(parseByte2HexStr(enCodeFormat))+"]");
			
			key = new SecretKeySpec(enCodeFormat, enType);

			// 初始化密文操作对象
			cipherEn.init(Cipher.ENCRYPT_MODE, key);

			// 初始化
			cipherDe.init(Cipher.DECRYPT_MODE, key);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			//logger.error("error", e);
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			//logger.error("error", e);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			//logger.error("error", e);
		}
	}

	/**
	 * 设置新的密钥
	 * 
	 * @param newkeycontent
	 * @return
	 */
	public synchronized static boolean setKeycontent(String newkeycontent) {
		keycontent = newkeycontent;
		return true;
	}

	/**
	 * 返回密钥
	 * 
	 * @return
	 */
	public static String getKeycontent() {
		return keycontent;
	}
	
	
	/**
	 * 加密包装器
	 * 
	 * @param 加密内容
	 *            ：content
	 * @param 密钥
	 *            ：keycontent
	 * @return
	 */
	public static String encryptWrap(String content) {
		byte[] cipherByte = encrypt(content);
		return parseByte2HexStr(cipherByte);
	}

	/**
	 * 解密包装器
	 * 
	 * @param 加密内容
	 *            ：content
	 * @param 密钥
	 *            ：keycontent
	 * @return
	 */
	public static String decryptWrap(String content) {
		byte[] decryptByte = decrypt(parseHexStr2Byte(content));
		return new String(decryptByte);
	}

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static byte[] encrypt(String content) {
		try {

			// 创建密码器
			byte[] byteContent = content.getBytes(encodeType);

			byte[] result = cipherEn.doFinal(byteContent);

			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] content) {
		try {

			byte[] result = cipherDe.doFinal(content);
			return result; // 解密
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuilder sb = new StringBuilder(32);

		int bufLength = buf.length;
		String hex = null;
		for (int i = 0; i < bufLength; i++) {
			hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex);
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;

		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////// base64 //////////////////////////////////////////////
	 /**    
     * BASE64解密
     * @param key          
     * @return          
     * @throws Exception          
     */              
    public static byte[] decryptBASE64(String key) throws Exception {               
        return (new BASE64Decoder()).decodeBuffer(key);               
    }             
    /**         
     * BASE64加密
   * @param key          
     * @return          
     * @throws Exception          
     */              
    public static String encryptBASE64(byte[] key) throws Exception {               
        return (new BASE64Encoder()).encode(key);               
    } 
    
	/**
	 * 加密包装器
	 * 
	 * @param 加密内容
	 *            ：content
	 * @param 密钥
	 *            ：keycontent
	 * @return
	 */
	public static String encryptWrapBASE64(String content) {
		byte[] cipherByte = encrypt(content);
		String data = null;
		try {
			data = encryptBASE64(cipherByte);
			if (data.charAt(data.length()-2) == '\r' && data.charAt(data.length()-1) == '\n') {
				data = data.substring(0, data.length()-2);
			}else if (data.charAt(data.length()-1) == '\n') {
				data = data.substring(0, data.length()-1);
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(data);
		
		
	}
	
	/**
	 * 解密包装器
	 * 
	 * @param 加密内容
	 *            ：content
	 * @param 密钥
	 *            ：keycontent
	 * @return
	 */
	public static String decryptWrapBASE64(String content) {		
		
		byte[] byteMing = null;
		
		try {
			byteMing = decryptBASE64(content);
		} catch (Exception e) {
				// TODO Auto-generated catch block
		e.printStackTrace();
		}     
        byte[] srcBytes = decrypt(byteMing);
        return new String(srcBytes);
        
	}
	
	
	/**
	 * 测试用例
	 * 
	 * @param args
	 */
	public static void main(String[] args) {		
		
		String formerPass = null;
		System.out.println("Please input your password:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
        	formerPass = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("original password: "+formerPass);
    	String encryPass = encryptWrap(formerPass);
    	System.out.println("after encrypted: "+encryPass);
	}

}
