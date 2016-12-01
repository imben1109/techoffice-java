package com.techoffice.example;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SimpleTest {
	
    @Deployment
    public static WebArchive createDeployment() {
    	WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war");
    	
    	File[] files = Maven.configureResolver().loadPomFromFile("pom.xml")
    		.importRuntimeAndTestDependencies().resolve().withTransitivity().asFile();
    	
        for(File file : files){
        	war.addAsLibrary(file);
        }       
        
    	war.addClass(TestBean.class);
    	war.addAsWebResource(new File("src/test/resources/faces/hello.xhtml"));
    	war.addAsWebResource(new File("src/test/resources/faces/welcome.xhtml"));
    	war.setWebXML(new File("src/test/resources/web.xml"));

        return war;
    }
    
    @Test
    public void test() {
    	
    }
}
