package com.techoffice.example;

import java.net.Socket;

public class Processor implements Runnable{

	private Socket socket;
	private Handler handler;
	
	public Processor(Socket socket, Handler handler){
		this.socket = socket;
		this.handler = handler;
	}
	
	public void run() {
		try{
			Request request = new Request(socket.getInputStream());
			Response response = new Response(socket.getOutputStream());
			handler.process(request, response);
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
