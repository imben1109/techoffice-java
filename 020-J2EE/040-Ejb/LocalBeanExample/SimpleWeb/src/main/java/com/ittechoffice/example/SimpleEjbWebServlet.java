package com.ittechoffice.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittechoffice.intf.Test;

public class SimpleEjbWebServlet extends HttpServlet{
	
	@EJB
	Test test;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String hi = test.sayHi();
		out.println("<h1>The Bean Say: " + hi + "</h1>");
	}

}
