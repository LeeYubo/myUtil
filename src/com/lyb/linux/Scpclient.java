package com.lyb.linux;

/**
 * 远程获取和上载Linux系统的文件
 * **/
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;

public class Scpclient {

	static private Scpclient instance;
	private String ip;
	private String username;
	private String password;

	static synchronized public Scpclient getInstance(String IP, String username, String passward) {
		if (instance == null) {
			instance = new Scpclient(IP, username, passward);
		}
		return instance;
	}

	public Scpclient(String IP, String username, String passward) {
		this.ip = IP;
		this.username = username;
		this.password = passward;
	}

	public void getFile(String remoteFile, String localTargetDirectory) {
		Connection conn = new Connection(ip);
		try {
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username,
					password);
			if (isAuthenticated == false) {
				System.err.println("authentication failed");
			}
			SCPClient client = new SCPClient(conn);
			client.get(remoteFile, localTargetDirectory);
			conn.close();
		} catch (IOException ex) {
			Logger.getLogger(SCPClient.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public void putFile(String localFile, String remoteTargetDirectory) {
		Connection conn = new Connection(ip);
		try {
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username,password);
			if (isAuthenticated == false) {
				System.err.println("authentication failed");
			}
			SCPClient client = new SCPClient(conn);
			client.put(localFile, remoteTargetDirectory);
			conn.close();
		} catch (IOException ex) {
			Logger.getLogger(SCPClient.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public void putFile(String localFile, String remoteFileName,
			String remoteTargetDirectory, String mode) {
		Connection conn = new Connection(ip);
		try {
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username,password);
			if (isAuthenticated == false) {
				System.err.println("authentication failed");
			}
			SCPClient client = new SCPClient(conn);
			if ((mode == null) || (mode.length() == 0)) {
				mode = "0600";
			}
			client.put(localFile, remoteFileName, remoteTargetDirectory, mode);

			//重命名
			ch.ethz.ssh2.Session sess = conn.openSession();
			String tmpPathName = remoteTargetDirectory + File.separator
					+ remoteFileName;
			String newPathName = tmpPathName.substring(0, tmpPathName
					.lastIndexOf("."));
			sess.execCommand("mv " + remoteFileName + " " + newPathName);//重命名回来

			conn.close();
		} catch (IOException ex) {
			Logger.getLogger(SCPClient.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static byte[] getBytes(String filePath) {
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream(
					1024 * 1024);
			byte[] b = new byte[1024 * 1024];
			int i;
			while ((i = fis.read(b)) != -1) {
				byteArray.write(b, 0, i);
			}
			fis.close();
			byteArray.close();
			buffer = byteArray.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {
		System.out.println("-------------------- start --------------------");
		Scpclient scp = Scpclient.getInstance("192.168.45.55","root","tsd2012psw");
		
		scp.getFile("/home/456.txt", "D:/");
		System.out.println("-------------------- end --------------------");
	}
}
