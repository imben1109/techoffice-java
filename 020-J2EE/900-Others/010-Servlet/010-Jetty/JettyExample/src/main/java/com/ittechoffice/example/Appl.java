package com.ittechoffice.example;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class Appl {
	public static void main(String[] args) throws Exception{
        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        
        handler.addServletWithMapping(ApplServlet.class, "/*");
        
        server.start();
        server.join();
	}
}
