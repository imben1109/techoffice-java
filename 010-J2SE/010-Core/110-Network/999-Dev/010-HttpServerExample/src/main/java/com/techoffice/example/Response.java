package com.techoffice.example;

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
	
}
