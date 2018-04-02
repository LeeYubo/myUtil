package com.lyb;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.apache.commons.lang3.StringUtils;

//使用InetAddress函数来获取本机名称和IP地址信息
public class NetInfo {

	public static void main(String[] args) {
		if(null==getVPNIpAddress()){
			System.out.println("获取VPN地址异常，请检查VPN是否已连接！");
		}
	}
	
	public static String getVPNIpAddress() {
		String ipAddress = null;
		try {
			for (Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces(); enumeration.hasMoreElements();) {
				NetworkInterface item = enumeration.nextElement();
				System.out.println("item.getDisplayName() = "+item.getDisplayName());
				if (StringUtils.isNoneBlank(item.getDisplayName()) && item.getDisplayName().contains("VPN")) {
					for (InterfaceAddress address : item.getInterfaceAddresses()) {
						if (address.getAddress() instanceof Inet4Address) {
							Inet4Address inet4Address = (Inet4Address) address.getAddress();
							ipAddress = inet4Address.getHostAddress();
							System.out.println(inet4Address.getHostAddress());
						}
					}
				}
			}
		} catch (IOException ex) {
			System.out.println("获取VPN IP地址异常，请检查VPN是否已连接！");
		}
		return ipAddress;
	}
}