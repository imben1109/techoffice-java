package com.techoffice.example;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Appl {
	
	@SuppressWarnings("serial")
	public static void main(String[] args) throws LifecycleException, IOException{		

	    Tomcat tomcat = new Tomcat();
	    tomcat.setPort(8080);
	    
	    //  
		File tempFolder = Files.createTempDirectory(null).toFile();
		tempFolder.deleteOnExit();
	    tomcat.setBaseDir(tempFolder.getAbsolutePath());
	    
	    // 
        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());
        
        File additionWebInfClasses = new File("target/classes");
        
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

	    tomcat.start();
	    
	    System.out.println("Server is starting at localhost:8080");
	    System.out.println("Server Temporay Directory: " + tempFolder.getAbsolutePath());
	    
	    tomcat.getServer().await();
	}
	
}
