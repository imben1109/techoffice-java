package com.techoffice.wordpress.oauth.server;

import org.eclipse.jetty.server.Server;

public class LocalServer {
	
	private String code;
	private Server server;
	private LocalServerHandler handler;
	
	public LocalServer(){
        server = new Server(8080);
        handler = new LocalServerHandler();
        handler.setOAuthLocalServer(this);
        server.setHandler(handler);
	}
	
	public void start() throws Exception  {
		server.start();
	}
	
	public void setCode(String lcode){
		this.code = lcode;
	}
	
	public String getCode(){
		return code;
	}
	
	public void waitFor() throws InterruptedException{
		server.join();
	}
	
}
