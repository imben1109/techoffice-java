package com.techoffice.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

public class TcpClientAppl {
	public static void main(String[] args) throws UnknownHostException, IOException{
		// start socket connection
		Socket socket = SocketFactory.getDefault().createSocket("localhost", 1010);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
	    // send message to server
	    printWriter.println("Send Message From Client" );
	    printWriter.flush();
//	    printWriter.close();
	    
	    // read message from server
	    System.out.println("Client starts reading from Server");
	    String line = bufferedReader.readLine();
		while(line != null && line.length() > 0){
			System.out.println(line);
			line = bufferedReader.readLine();
		}
//		bufferedReader.close();
	    
		// close scoket connection
		socket.close();
	}
}
