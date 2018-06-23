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
				Request request = new Request(socket.getInputStream());
				Response response = new Response(socket.getOutputStream());
				handler.process(request, response);
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
            
    	}
    }
}
