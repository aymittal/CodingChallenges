package com.ayush.design.pattern.loadBalancer;

public class Main {

	public static void main(String[] args) {
		LoadBalancer lb = LoadBalancer.getInstance();
		for(int i = 0; i < 10; i++) {
			Server server = lb.getServer();
			System.out.printf("Request was sent to %s at IP Address %s.\n",
			          server.getServerName(), server.getServerIP());
		}
	}
}