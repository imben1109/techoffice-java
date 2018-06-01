package com.techoffice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.springframework.web.servlet.DispatcherServlet;

public class Appl {

	public static void main(String[] args) throws Exception{
		
        Server server = new Server(8080);
        
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        server.setHandler(servletContextHandler);

        ServletHandler servletHandler = new ServletHandler();
        ServletHolder servletHolder = new ServletHolder();

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        servletHolder.setServlet(dispatcherServlet);
        servletHolder.setInitParameter("contextConfigLocation", "classpath:/webapp/WEB-INF/beans.xml");
        servletHandler.addServletWithMapping(servletHolder, "/");
        
        servletContextHandler.setServletHandler(servletHandler);
        servletContextHandler.setBaseResource(Resource.newClassPathResource("/webapp"));

        server.start();
        server.join();
	}
	
}
