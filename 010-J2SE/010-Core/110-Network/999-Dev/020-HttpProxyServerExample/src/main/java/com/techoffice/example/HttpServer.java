package com.techoffice.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    ServerSocket serverSocket = null; 
    int port = 8080;
    boolean isShutDown = false;
    Handler handler = new Handler();
    
    public void await() {
    	try{
            serverSocket = new ServerSocket(port);    		
    	}catch(Exception e){
    		e.printStackTrace();
    		System.exit(1);;
    	}
    	
    	while (!isShutDown){
            try {
				Socket socket = serverSocket.accept();
				(new Thread(new Processor(socket, handler))).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
            
    	}
    }
}
