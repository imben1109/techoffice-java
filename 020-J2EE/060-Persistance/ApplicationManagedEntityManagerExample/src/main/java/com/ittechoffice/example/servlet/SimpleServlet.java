package com.ittechoffice.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittechoffice.example.model.User;

public class SimpleServlet extends HttpServlet{
	
	@PersistenceUnit
	EntityManagerFactory EntityManagerFactory ;
	
	EntityManager entityManager;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		if (entityManager == null){
			entityManager = EntityManagerFactory.createEntityManager();
		}
		User user = new User();
		user.setName("TestUser1");
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Simple Persistence Example</h1>");
		out.println("<h2>Table: User</h2>");
		out.println("<table border='1'>");
		out.println("<tr><td>ID</td><td>Name</td></tr>");
		List<User> results = entityManager.createQuery("from User", User.class).getResultList();
		for (User result: results){
			out.println("<tr>");
			out.println("<td>");
			out.println(result.getId());
			out.println("</td>");
			out.println("</td>");
			out.println("<td>");
			out.println(result.getName());
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
	}
}
