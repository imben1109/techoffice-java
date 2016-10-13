package com.ittechoffice.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPClient {
	public static void main(String[] args) throws UnknownHostException, IOException{
	    InetAddress hostAddress = InetAddress.getByName("localhost");
	    byte[] buf = "Hello, This is UDP Client. ".getBytes();
	    DatagramPacket out = new DatagramPacket(buf, buf.length, hostAddress, 8080);
	    DatagramSocket socket = new DatagramSocket();
	    socket.send(out);
	}
}
