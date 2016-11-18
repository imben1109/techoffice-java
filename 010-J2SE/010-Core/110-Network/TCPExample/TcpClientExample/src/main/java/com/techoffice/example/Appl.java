package com.ittechoffice.example;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Appl {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket socket = new Socket("localhost", 8080);
		socket.close();
	}
}
