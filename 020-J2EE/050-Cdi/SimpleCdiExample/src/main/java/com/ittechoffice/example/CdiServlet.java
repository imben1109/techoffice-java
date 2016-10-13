package com.ittechoffice.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CdiServlet extends HttpServlet{
	
	@Inject
	private Test test;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		test.sayHi();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>IT Tech CDI Example</h1>");
	}

}
