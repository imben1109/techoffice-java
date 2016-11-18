package com.ittechoffice.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Appl {
	public static void main(String[] args) throws UnknownHostException, IOException{
		int port = 8080;
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server is running on " + port);
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println("Someone is connecting to the server");
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			InputStreamReader r;
			PrintWriter writer = new PrintWriter(os);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			writer.println("This is a Server Socket Test");
			socket.close();
		}
		
		
		
	}
}
