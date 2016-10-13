package com.ittechoffice.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.UnknownHostException;

public class UDPServer {
	public static void main(String[] args) throws UnknownHostException, IOException{
		int port = 8080;
	    byte[] buf = new byte[1000];
		DatagramSocket serverSocket = new DatagramSocket(port);
		System.out.println("Server is running on " + port);
		while(true){
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			serverSocket.receive(packet);
			String message = new String(packet.getData());
			System.out.println("Message Received: " + message);
		}
	}
}
