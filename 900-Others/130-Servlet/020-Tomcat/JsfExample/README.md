# Emebedded Tomcat JSF Example

## Example
This example show simple JSF Application on Embedded Tomcat. It is very similar to JSPExample and add JSF capacity to it so that JSF Dependencies are required to add to pom.xml. 

src/main/webapp/WEB-INF/web.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>JavaServerFaces</display-name>
  <context-param>
    <param-name>javax.faces.PROJECT_STAGE</param-name>
    <param-value>Development</param-value>
  </context-param>
  <welcome-file-list>
    <welcome-file>faces/hello.xhtml</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>faces</servlet-name>
    <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>faces</servlet-name>
    <url-pattern>*.xhtml</url-pattern>
  </servlet-mapping>
</web-app>
```

Appl.java (Main Program for Main Application)
```
public class Appl {
	private final static String webappPath = "src/main/webapp";
	
	public static void main(String[] args) throws ServletException, LifecycleException {
		File file = new File(webappPath);
		System.out.println(file.getAbsolutePath());
		
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappPath).getAbsolutePath());
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();

	}
}
```

HelloBean (Managed Bean)
```
package com.ittechoffice.example;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {
	private String hello = "Hello123!!";
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getHello(){
		return hello;
	}
	

}
```

hello.xhtml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:f="http://java.sun.com/jsf/core"      
      xmlns:h="http://java.sun.com/jsf/html">
	
    <h:head>
        <title>JSF 2.0 Hello World</title>
    </h:head>
    <h:body>
    	<h2>JSF 2.0 Hello World Example - hello.xhtml</h2>
    	<div>${helloBean.hello}</div>
    	<h:form>
    	   <h:inputText value="#{helloBean.name}"></h:inputText>
    	   <h:commandButton value="Welcome Me" action="welcome"></h:commandButton>
    	</h:form>
    </h:body>
</html>
```

welcome.xhtml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"    
      xmlns:h="http://java.sun.com/jsf/html">
	
    <h:head>
    	<title>JSF 2.0 Hello World</title>
    </h:head>
    <h:body bgcolor="white">
    	<h2>JSF 2.0 Hello World Example - welcome.xhtml</h2>
    	<h2>Welcome #{helloBean.name}</h2>
    </h:body>
</html>
```


## JSF Dependenecis
```
<!-- JSP Standard Tag Library -->
<dependency>
	<groupId>jstl</groupId>
	<artifactId>jstl</artifactId>
	<version>1.2</version>
</dependency>

<!-- Mojarra JSF  -->
<dependency>
	<groupId>com.sun.faces</groupId>
	<artifactId>jsf-api</artifactId>
	<version>2.1.13</version>
</dependency>
<dependency>
	<groupId>com.sun.faces</groupId>
	<artifactId>jsf-impl</artifactId>
	<version>2.1.13</version>
</dependency>

<!-- Servlet -->
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.0.1</version>
</dependency>
```
