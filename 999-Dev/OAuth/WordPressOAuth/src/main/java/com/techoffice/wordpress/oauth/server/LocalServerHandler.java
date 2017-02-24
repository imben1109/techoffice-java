package com.techoffice.wordpress.oauth.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

/**
 * Handler for Local Server. It handles the request and response of the Jetty Server. 
 * Once authorized code is received from the jetty server, it would stop the Jetty server.  
 * 
 * @author Ben_c
 *
 */
public class LocalServerHandler implements Handler {

	/**
	 * Jetty Server
	 */
	private Server server;
	
	/**
	 * Local Server
	 */
	private LocalServer oAuthLocalServer;

	/**
	 * This method handle the request and response 
	 */
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		// Get Code from the parameter
		String code = request.getParameter("code");
		System.out.println("code: " + code);
		
		// If the code is not null 
		if (!"".equals(code)){
			oAuthLocalServer.setCode(code);
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html><head><title>Tech Office</title></head><p>The Code obtained. Please close this browser</p></body></html>");
		    out.flush();
			response.flushBuffer();
			baseRequest.setHandled(true);
			
			// Stop the jetty server after handling the request.
			try{
				stop();
			}catch (Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Stop Jetty Server
	 * 
	 * @throws Exception
	 */
	public void stop() throws Exception {
		// shut down all jetty server connector 
		for (Connector connector : server.getConnectors()) {
			connector.shutdown();
		}
		
		// Create a thread to stop Jetty Server
		new Thread() {
			@Override
			public void run() {
				try {
					server.stop();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (Exception e) {
					throw new RuntimeException("Shutting down server", e);
				}
			}
		}.start();
	}
	
	public void setServer(Server server) {
		this.server = server;
	}

	public Server getServer() {
		return server;
	}
	
	public void setOAuthLocalServer(LocalServer oAuthLocalServer){
		this.oAuthLocalServer = oAuthLocalServer;
	}
	
	public LocalServer oAuthLocalServer(){
		return oAuthLocalServer;
	}
	
	
	public void start() throws Exception {}
	
	public void destroy() {}
	public boolean isRunning() {return false;}
	public boolean isStarted() {return false;}
	public boolean isStarting() {return false;}
	public boolean isStopping() {return false;}
	public boolean isStopped() {return false;}
	public boolean isFailed() {return false;}
	public void addLifeCycleListener(Listener listener) {}
	public void removeLifeCycleListener(Listener listener) {}
	
}
