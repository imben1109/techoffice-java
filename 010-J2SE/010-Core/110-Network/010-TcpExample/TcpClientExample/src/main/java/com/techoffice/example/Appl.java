package com.techoffice.example;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Appl {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{
		Socket socket = new Socket("localhost", 1010);
		OutputStream os = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(os);
		writer.println("testing");
		writer.flush();
		writer.close();
		socket.close();					
	}
}
