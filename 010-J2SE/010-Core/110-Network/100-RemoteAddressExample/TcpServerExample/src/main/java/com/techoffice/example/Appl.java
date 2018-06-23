package com.techoffice.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Appl {
	
	static int port = 1010;
	static ServerSocket serverSocket;
	static {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{
		System.out.println("Server is running on " + port);
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println("Someone is connecting to the server using " + socket.getRemoteSocketAddress());
			socket.close();
		}
	}
}
