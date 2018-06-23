package com.techoffice.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {

	OutputStream output;

	public Response(OutputStream output){
		this.output = output;
	}
	
	public void print(String str){
		PrintWriter printWriter = new PrintWriter(output);
		printWriter.println(str);
		printWriter.flush();
	}
	
	public void print(final InputStream in){
		try {
			int bufferSize = 1048576;
			byte[] buffer = new byte[bufferSize];
			int read = -1;
			int count = 0;
			while ( (read = in.read(buffer)) != -1){
				output.write(buffer, count*bufferSize, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
