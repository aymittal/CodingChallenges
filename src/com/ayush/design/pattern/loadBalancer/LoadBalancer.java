package com.ayush.design.pattern.loadBalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {

	private static LoadBalancer instance;

	private List<Server> servers = new ArrayList<>();

	private Random rand = new Random();

	private LoadBalancer() {
		servers.add(new Server("Server 1", "192.168.252.1"));
		servers.add(new Server("Server 2", "192.168.252.2"));
		servers.add(new Server("Server 3", "192.168.252.3"));
		servers.add(new Server("Server 4", "192.168.252.4"));
		servers.add(new Server("Server 5", "192.168.252.5"));
	}

	public static LoadBalancer getInstance() {
		if (instance == null)
			instance = new LoadBalancer();
		return instance;
	}

	public Server getServer() {
		int random = rand.nextInt(servers.size());
		return servers.get(random);

	}
}