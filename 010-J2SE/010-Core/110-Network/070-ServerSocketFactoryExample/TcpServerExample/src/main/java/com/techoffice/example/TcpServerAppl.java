package com.techoffice.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;

public class TcpServerAppl {
	
	static int port = 1010;
	static ServerSocket serverSocket;
	static {
		try {
			serverSocket = ServerSocketFactory.getDefault().createServerSocket(port);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Server is running on " + port);
		while(true){
			Socket socket = null;
			try{		
				socket = serverSocket.accept();
				System.out.println("Someone is connecting to the server");
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				PrintWriter printWriter = new PrintWriter(os);
				
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
				
				// read message from client 
			    String line = bufferedReader.readLine();
				while(line != null && line.length() > 0){
					System.out.println(line);
					line = bufferedReader.readLine();
				}
//				reader.close();

				// send message to client
				System.out.println("Server starts sending message to client");
				printWriter.println("This is a message sent from server");
				printWriter.flush();
//				printWriter.close();
				
			} catch(Exception e){
				System.err.println(e.getMessage());
			} finally {
				if (socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						System.err.println(e.getMessage());
					}
				}
			}
		}

	}
}
