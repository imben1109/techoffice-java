package com.techoffice.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class TechOfficeServletResponseWrapper extends HttpServletResponseWrapper {

	public TechOfficeServletResponseWrapper(HttpServletResponse response) {
		super(response);
	}
	
    public PrintWriter getWriter() throws IOException {
    	System.out.println("Customized Response");
    	return this.getResponse().getWriter();
	}
}
