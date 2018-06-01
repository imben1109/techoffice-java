package com.techoffice.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Appl {
	private final static String webappPath = "src/main/webapp";
	
	public static void main(String[] args) throws ServletException, LifecycleException, IOException {
		File webapp = new File(webappPath);
		System.out.println(webapp.getAbsolutePath());
		
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        
        //  
		File tempFolder = Files.createTempDirectory(null).toFile();
		tempFolder.deleteOnExit();
	    tomcat.setBaseDir(tempFolder.getAbsolutePath());

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", webapp.getAbsolutePath());
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();

	}
}
