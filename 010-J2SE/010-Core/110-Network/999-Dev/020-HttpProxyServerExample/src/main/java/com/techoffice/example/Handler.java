package com.techoffice.example;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

public class Handler {

	private String getRequestUrl(String content){
		try{
			String requestUrl = content.substring(content.indexOf(' ')+1);
			requestUrl = requestUrl.substring(0, requestUrl.indexOf(' '));
			return requestUrl;
		}catch(Exception e){
			System.out.println(content);
		}
		return null;
	}
	
	public void process(Request request, Response response){
		long startTime = System.currentTimeMillis();
		try{
			String content = request.getContent();			
			String requestUrl = getRequestUrl(content);
			String host = "";
			if (requestUrl.startsWith("http://")){
				host = requestUrl.substring("http://".length());
				host = host.substring(0, host.indexOf("/") );
			}
			Socket socket = new Socket(host, 80);			
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.print(content);
			printWriter.flush();
			response.print(socket.getInputStream());
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time Used: " + (endTime - startTime));
	}
	
}
