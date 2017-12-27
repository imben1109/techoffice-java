package com.techoffice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static ServerSocket server;

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		server = new ServerSocket(8881);
		while(true){
			Socket socket = server.accept();			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Test test = (Test) ois.readObject();
			System.out.println(test.getName());
		}
	}
}
