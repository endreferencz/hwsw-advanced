package com.epam.jpatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.h2.tools.Server;

public class H2DatabaseServer {
	private static Server tcpServer;
	private static Server webServer;
		
	public static void main(String[] args) throws IOException {
		
		start();
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter server command (status|stop|start): ");
	        String command = br.readLine();
	        if ("stop".equalsIgnoreCase(command)) {
	        	stop();
	        }
	        else if ("status".equalsIgnoreCase(command)) {
	        	status();
	        }
	        else if ("start".equalsIgnoreCase(command)) {
	        	start();
	        }
	        else {
	        	System.out.println("Unknown command.");	
	        }
		}
		
	}

	private static void start() {
		try {
			tcpServer = Server.createTcpServer("-tcp", "-tcpAllowOthers").start();
			webServer = Server.createWebServer("-web", "-webAllowOthers").start();
			status();
		} catch (SQLException e) {
			System.out.printf("Cannot start database server, reason: %s\n", e.getMessage());
		}
	}
	
	private static void stop() {
		tcpServer.stop();
		webServer.stop();
		status();
	}
	
	private static void status() {
		System.out.println("SERVER STATUS:");
		System.out.printf("TCP server: %s\n", tcpServer.getStatus());
		System.out.printf("Web server: %s\n", webServer.getStatus());
		System.out.println();
	}

}
