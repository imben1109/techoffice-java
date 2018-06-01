package com.techoffice.example;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class Appl {
    public static Server server = new Server(8080);
    
    public Appl() throws Exception{
        ApplHandler handler = new ApplHandler();
        server.setHandler(handler);       
        server.start();
    }
    
    

	public static void main(String[] args) throws Exception{
		new Appl();
	}
}
