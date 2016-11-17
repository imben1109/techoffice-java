package com.techoffice.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import com.sun.net.httpserver.HttpServer;
import com.techoffice.example.handler.RootHandler;
import com.techoffice.example.handler.TestHandler;

public class HttpServerAppl {
	public static void main(String[] args) throws UnknownHostException, IOException{
		int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/test", new TestHandler());
        server.setExecutor(null); 
        
        System.out.println("Simple Http Server is running on " + port);
        
        server.start();
	}

}
