package com.techoffice.example;

import java.io.IOException;
import java.io.InputStream;

public class Request {

	InputStream input = null;
	
	public Request(InputStream input){
		this.input = input;
	}
	
	public String getContent() throws IOException{
	    StringBuffer request = new StringBuffer(2048);
	    byte[] buffer = new byte[2048];
	    int result = input.read(buffer);
	    for (int j=0; j < result; j++) {
	        request.append((char) buffer[j]);
	    }
	    return request.toString();
	}
}
