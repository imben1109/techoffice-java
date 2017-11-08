package com.techoffice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TechOfficeServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String user = (String) request.getParameter("user");
		String password = (String) request.getAttribute("password");
		
		HttpSession session = request.getSession();

		session.setAttribute("user", user);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Authenticate</h1>");
	}
}
