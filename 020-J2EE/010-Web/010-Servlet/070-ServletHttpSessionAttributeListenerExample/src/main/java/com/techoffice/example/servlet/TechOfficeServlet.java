package com.techoffice.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TechOfficeServlet extends HttpServlet{

	private static final long serialVersionUID = -4628454249235124433L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Tech Office Test Servlet Listener Example Update</h1>");
		
	}
}
