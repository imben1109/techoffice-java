package com.techoffice.wordpress.oauth;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class LocalServer {
	
	private static String code;
	
	private static Server server;

	static {
        server = new Server(8080);
        LocalServerHandler handler = new LocalServerHandler();
        server.setHandler(handler);
	}
	
	public static void start()  {
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setCode(String lcode){
		code = lcode;
	}
	
	public static String getCode(){
		return code;
	}
	
	public static void waitFor(){
		try {
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
