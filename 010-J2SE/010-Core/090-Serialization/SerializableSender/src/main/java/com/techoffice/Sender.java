package com.techoffice;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Sender {

	static ServerSocket server;

	public static void main(String[] args) throws IOException, ClassNotFoundException{
	    Socket client = new Socket() ; 
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 8881); 
        client.connect(isa, 0);
        Test test = new Test();
        test.setName("Test");
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(test);
        oos.flush();
        oos.close();
        client.close();
	}
}
