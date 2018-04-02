package com.lyb.xml.sax;

import java.util.List;

public class Server {

	private String id;
	private String hostname;
	private String hostip;
	private String username;
	private String password;
	
	private List<Application> listApp= null;
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getHostip() {
		return hostip;
	}
	public void setHostip(String hostip) {
		this.hostip = hostip;
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
	public List<Application> getListApp() {
		return listApp;
	}
	public void setListApp(List<Application> listApp) {
		this.listApp = listApp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
