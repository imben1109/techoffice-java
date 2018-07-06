package com.techoffice.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TechOfficeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.getAttribute("Testing");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Tech Office Test Servlet Example Update</h1>");
	}
}
