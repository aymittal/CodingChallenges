package com.ayush.design.pattern.loadBalancer;

public class Server {

	private String serverName;
	private String serverIP;

	public Server(String serverName, String serverIP) {
		super();
		this.serverName = serverName;
		this.serverIP = serverIP;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
}