package com.techoffice.oauth;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class LocalServer {
	
	private static String code;
	
	private static Server server;
	
	public LocalServer(){
        server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(LocalServerHandler.class, "/*");
	}
	
	public void start()  {
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setCode(){
		try {
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitFor(){
		try {
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
