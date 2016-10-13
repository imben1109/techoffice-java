package com.ittechoffice.example;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.servlet.JspServlet;
import org.apache.tomcat.InstanceManager;
import org.apache.tomcat.SimpleInstanceManager;
import org.eclipse.jetty.annotations.ServletContainerInitializersStarter;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.plus.annotation.ContainerInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class JspAppl {
	public static void main(String[] args) throws Exception{
		
		String root = Paths.get(JspAppl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		File webappFile = new File(root, "src/webapp");
		String webappPath = webappFile.getPath();
		System.out.println(webappFile);

		System.setProperty("org.apache.jasper.compiler.disablejsr199","false");

		
        // Web App
        WebAppContext context = new WebAppContext();
        context.setDescriptor(webappPath+"/WEB-INF/web.xml");
        context.setResourceBase(webappPath);
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        // Make Jetty Support Jsp 
		JettyJasperInitializer sci = new JettyJasperInitializer();
		ContainerInitializer initializer = new ContainerInitializer(sci, null);
		List<ContainerInitializer> initializers = new ArrayList<ContainerInitializer>();
		initializers.add(initializer);
		context.setAttribute("org.eclipse.jetty.containerInitializers", initializers);
		context.setAttribute(InstanceManager.class.getName(), new SimpleInstanceManager());
		context.addBean(new ServletContainerInitializersStarter(context), true);

        // Jsp Servlet
        ServletHolder holderJsp = new ServletHolder("jsp",JspServlet.class);
        holderJsp.setInitOrder(0);
        holderJsp.setInitParameter("keepgenerated", "true");
        context.addServlet(holderJsp, "*.jsp");
        
        // Set Server
        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        server.join();
	}
}
