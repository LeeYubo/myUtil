package com.lyb.file;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FileOper_FTP {

	public static String hostIP="127.0.0.1";			//FTP服务器IP
	public static String username;						//登录FTP服务器账号
	public static String password;						//登录FTP服务器账号对应的密码
	public static int port=21;							//登录FTP服务器端口号
	public static String filename;						//登录FTP服务器账号对应的密码
	
	
	/**
	 * @author Administrator
	 * 初始化类的属性，从配置文件中读取。
	 * 
	 * */
	public static void Initial(){
//		String LocalServer = Share.readIniValue("System", "LocalServer");
//		String LocalServerPass = Share.readIniValue("System", "LocalServerPass");
//		FileOper.username = LocalServer;
//		FileOper.password = LocalServerPass;
	}
	
	
	/**
	 * 连接FTP服务器
	 * @author Administrator
	 * @param  hostIP：FTP服务器IP
	 * @param  port：登录FTP服务器端口号
	 * @param  username：登录FTP服务器账号
	 * @param  password：登录FTP服务器账号对应的密码
	 * @return FTPClient：返回连接FTP服务器的客户端FTPClient类的对象
	 * */
	public static FTPClient getConn(String hostIP,int port, String username, String password){
		FTPClient ftpClient = new FTPClient();
		int reply;
		
		//先要对密码进行解密
		String passwordDecrypted = "";
		try {
//			passwordDecrypted = AESUtil.decryptWrap(password);
		} catch (Exception e) {
			//解密加密之后的密码时发生错误！
//			Log.getLogger().error(International.getProperty("FileOper.DecryptError"));
//			Log.getLogger().error(International.getProperty("SortMain.ThrownException"),e);
		}
		
		try {
			ftpClient.connect(hostIP, port);
			ftpClient.login(username, passwordDecrypted);//登录
			reply = ftpClient.getReplyCode();//登录的返回值，等于230时表示登录成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				ftpClient = null;
//				Log.getLogger().error(International.getProperty("FileOper.LoginFail"));
			}else{
//				Log.getLogger().info(International.getProperty("FileOper.LoginSuccess"));
			}
		} catch (SocketException e) {
//			Log.getLogger().error(International.getProperty("SortMain.ThrownException"),e);
		} catch (IOException e) {
//			Log.getLogger().error(International.getProperty("SortMain.ThrownException"),e);
		}
		return ftpClient;
	}
	
	
	/**
     * 检测要保存的本地路径是否存在
     * @author Administrator
     * @param localPath：本地路径
     * @return 检测的结果，存在时返回true，不存在返回false
     * */
    public static boolean checkDestination(String localPath){
    	Boolean result = true;
    	File file = new File(localPath); 
		if(!file.exists()){
			//话单文件目的路径不存在
			result = false;
//			Log.getLogger().error(International.getProperty("FTP.NoDestination")+localPath);
		}
    	return result;
    }
    
    
    /**
     * 删除服务器上的文件
     * @author Administrator
     * @param ftpFile：要删除的话单文件名称
     * 
     * */
    public static void deleteFile(String fileName){
    	FTPClient ftp = new FTPClient();
    	ftp = getConn(hostIP,port,username,password);
    	if(!"".equals(fileName)){
			if(null != ftp){
				try {
					if(ftp.deleteFile(fileName)){
						//删除成功
//						Log.getLogger().info(International.getProperty("FileOper.RemoveSuccess")+fileName);
					}else{
//						Log.getLogger().info(International.getProperty("FileOper.RemoveFailure")+fileName);
					}
				} catch (Exception e) {
					//转移到FTP服务器话单目录 出现异常
//					Log.getLogger().error(International.getProperty("SortMain.ThrownException"),e);
				} finally {
					//关闭连接
	    			FileOper_FTP.LogOut(ftp);
				}
			}
    	}
    }
	
	
    /**
     * 关闭连接
     * @author Administrator
     * @param ftp:FTPClient连接的具体对象
     * */
    public static void LogOut(FTPClient ftp){
    	boolean resultLogout  = false;
    	if(null != ftp){
    		try {
    			resultLogout = ftp.logout();
    			if(resultLogout){
    				//注销返回的结果，true表示注销成功！
//    				Log.getLogger().info(International.getProperty("FileOper.LogOutSuccess")+"\n");
    			}else{
//    				Log.getLogger().info(International.getProperty("FileOper.LogOutFailed"));
    			}
	        } catch (IOException e) {
//	        	Log.getLogger().error(International.getProperty("FileOper.LogoutError"));
//	        	Log.getLogger().error(International.getProperty("SortMain.ThrownException"),e);
	        } finally {
	        	if (ftp.isConnected()) {
					try {
						ftp.disconnect();
					} catch (IOException ioe) {
//						Log.getLogger().error(International.getProperty("SortMain.ThrownException"),ioe);
					}
				}
	        }
    	}
    }
    
    
    /**
     * @author Administrator
     * 根据指定目录和要过滤的文件名称，获取话单文件名称列表
     * @param 
     * */
    public static List<String> getFileList(String remotePath, String filterName){
    	ArrayList<String> fileList = new ArrayList<String>();
    	FTPClient ftp = new FTPClient();
    	ftp = getConn(hostIP,port,username,password);
    	String fileName = "";
    	boolean fileType = false;
    	boolean filterRes = false;
    	
    	//对过滤文件名称进行处理
    	String prefixName = "";//过滤文件名的前缀
		String suffixName = "";//过滤文件名的后缀
		
    	if(-1!=filterName.indexOf(".")){
    		String nameArray [] = filterName.split("\\.");
			if(nameArray.length>1){
				prefixName = nameArray[0];//过滤文件名的前缀
				suffixName = nameArray[1];//过滤文件名的后缀
			}
			if(prefixName.endsWith("*")){
				prefixName = prefixName.replaceAll("\\*", "");
			}
			if(suffixName.endsWith("*")){
				suffixName = suffixName.replaceAll("\\*", "");
			}
			filterRes = true;
    	}
    	
    	System.out.println("prefixName = "+prefixName);
    	System.out.println("suffixName = "+suffixName);
    	
    	boolean resultDir = false;
    	if(null != ftp){
			try {
				//转移到FTP服务器话单目录
				resultDir = ftp.changeWorkingDirectory(remotePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

    	//切换至话单所在目录成功
    	if(resultDir){
    		if(filterRes){
    			try {
        			FTPFile[] fileArray = ftp.listFiles();
        			if(fileArray.length>0){
        				for(int i=0;i<fileArray.length;i++){
        					//判断是否是文件，如果是返回true，否则返回false
        					fileType = fileArray[i].isFile();
        					if(fileType){
        						fileName = fileArray[i].getName();
        						System.out.println(fileName);
        						//如果是以过滤的后缀结束，且包含前缀，则是要获取的文件
        						if(fileName.endsWith(suffixName) && -1!=fileName.indexOf(prefixName)){
        							fileList.add(fileName);
        						}
        					}else{
        						continue;
        					}
        				}
        			}
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
    		}else{
				try {
					FTPFile[] fileArray = ftp.listFiles();
					if(fileArray.length>0){
	    				for(int i=0;i<fileArray.length;i++){
	    					//判断是否是文件，如果是返回true，否则返回false
	    					fileType = fileArray[i].isFile();
	    					if(fileType){
	    						fileName = fileArray[i].getName();
	    						System.out.println(fileName);
	    						fileList.add(fileName);
	    					}else{
	    						continue;
	    					}
	    				}
	    			}
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	return fileList;
    }
    
    
    
    
    public static void delete(String filePath){
    	File file = new File(filePath);
    	if(file.exists() && file.isFile()){
    		if(file.delete()){
    			System.out.println("成功删除文件="+filePath);
    		}
    	}
    }
    
    
    public static void getFileNames(String folder, String filterName){
    	ArrayList<String> fileList = new ArrayList<String>();
    	
    	boolean filterRes = false;
    	//对过滤文件名称进行处理
    	String prefixName = "";//过滤文件名的前缀
		String suffixName = "";//过滤文件名的后缀
		
    	if(-1!=filterName.indexOf(".")){
    		String nameArray [] = filterName.split("\\.");
			if(nameArray.length>1){
				prefixName = nameArray[0];//过滤文件名的前缀
				suffixName = nameArray[1];//过滤文件名的后缀
			}
			if(prefixName.endsWith("*")){
				prefixName = prefixName.replaceAll("\\*", "");
			}
			if(suffixName.endsWith("*")){
				suffixName = suffixName.replaceAll("\\*", "");
			}
			filterRes = true;
    	}
    	
    	System.out.println("prefixName = "+prefixName);
    	System.out.println("suffixName = "+suffixName);
    	
    	
    	File file = new File(folder);
    	File[] files = file.listFiles();
    	String fileName = "";
    	
    	if(filterRes){
    		
    		if(files.length>0){
				for(int i=0;i<files.length;i++){
					//判断是否是文件，如果是返回true，否则返回false
					if(files[i].isFile()){
						fileName = files[i].getName();
						//如果是以过滤的后缀结束，且包含前缀，则是要获取的文件
						if(fileName.endsWith(suffixName) && -1!=fileName.indexOf(prefixName)){
							fileList.add(fileName);
						}
					}else{
						continue;
					}
				}
			}
    	}else{
    		if(files.length>0){
    			for (int i = 0; i < files.length; i++) {
    				if (files[i].isFile()) {
    					fileList.add(files[i].getName());
    				}
    			}
    		}
    	}
    	
    	
    	for(int j=0;j<fileList.size();j++){
    		System.out.println("  9999  "+fileList.get(j));
    	}
    	
    }
    
    
    public static void main(String[] args) {
    	
    	FileOper_FTP.hostIP="192.168.45.53";
    	FileOper_FTP.Initial();
//    	FileOper.deleteFile("/home/liyubo/BK/123.txt");
//    	FileOper.getFileList("/usr/local/BillSort/file/bill/NGN","b000003*.dat");
//    	FileOper.delete("D:/HDFJ/test/BK/NGN/b00000215.dat");
    	
    	FileOper_FTP.getFileNames("D:/test/billFile/CC08", "*");
	}
}
