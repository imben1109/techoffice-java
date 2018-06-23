package com.techoffice.example;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Appl {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{
		Socket socket = new Socket("localhost", 1010);
		socket.close();					
	}
}
