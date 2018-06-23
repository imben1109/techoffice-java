package com.techoffice.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler implements Runnable{

	private Socket socket;
	
	public SocketHandler(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try{
			System.out.println("Someone is connecting to the server");
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
//			InputStreamReader r;
			PrintWriter writer = new PrintWriter(os);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			writer.println("This is a Server Socket Test");
			Thread.sleep(10000);
			System.out.println("close");
			socket.close();
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	
}
