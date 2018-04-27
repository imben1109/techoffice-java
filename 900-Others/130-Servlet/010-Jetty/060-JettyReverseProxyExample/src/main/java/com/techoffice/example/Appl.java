package com.techoffice.example;
import org.eclipse.jetty.proxy.ProxyServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Appl {
	public static void main(String[] args) throws Exception{
        Server server = new Server(8888);
        
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        server.setHandler(servletContextHandler);

        ServletHandler servletHandler = new ServletHandler();
        ServletHolder servletHolder = new ServletHolder();

        ProxyServlet proxyServlet = new ProxyServlet.Transparent();
        servletHolder.setServlet(proxyServlet);
        servletHolder.setInitParameter("proxyTo", "http://localhost:8080");
        servletHolder.setInitParameter("prefix", "/");
        servletHandler.addServletWithMapping(servletHolder, "/");
        
        servletContextHandler.setServletHandler(servletHandler);

        server.start();
        server.join();        
        
	}
}
