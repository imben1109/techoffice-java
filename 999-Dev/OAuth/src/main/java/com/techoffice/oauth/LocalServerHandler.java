package com.techoffice.oauth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;

public class LocalServerHandler implements Handler {

	private Server server;

	public void start() throws Exception {

	}

	public void stop() throws Exception {

	}

	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStarting() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStopping() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStopped() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isFailed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void addLifeCycleListener(Listener listener) {
		// TODO Auto-generated method stub

	}

	public void removeLifeCycleListener(Listener listener) {
		// TODO Auto-generated method stub

	}

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String code = request.getParameter("code");
		
		System.out.println("code: " + code);
		
		if (!"".equals(code)){
			LocalServer.setCode(code);
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Tech Office</title>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<p>The Code obtained. Please close this browser</p>");
		    out.println("</body>");
		    out.println("</html>");
		    out.flush();
			response.flushBuffer();

			baseRequest.setHandled(true);
			
			for (Connector connector : server.getConnectors()) {
				connector.shutdown();
			}
			final Server server = getServer();
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
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Server getServer() {
		return server;
	}

	public void destroy() {
	}

}
