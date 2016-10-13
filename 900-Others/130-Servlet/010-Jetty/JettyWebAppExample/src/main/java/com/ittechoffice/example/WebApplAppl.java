package com.ittechoffice.example;

import java.io.File;
import java.nio.file.Paths;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebApplAppl {
	public static void main(String[] args) throws Exception{		
		String root = Paths.get(WebApplAppl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		File webappFile = new File(root, "src/webapp");
		String webappPath = webappFile.getPath();
		System.out.println(webappFile);
		
        WebAppContext context = new WebAppContext();
        context.setDescriptor(webappPath+"/WEB-INF/web.xml");
        context.setResourceBase(webappPath);
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        server.join();		
	}
}
