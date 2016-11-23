# Embedded Tomcat JSP Example

## Example
It differs from TomcatExample. The embedded tomcat run with web app context provided by tomcat while TomcatExample does not. This example create a tomcat web app context with a index.jsp. The index.jsp would render "Embedded Tomcat Jsp Example". 

Appl.java
```
public class Appl {
	private final static String webappPath = "src/main/webapp";
	
	public static void main(String[] args) throws ServletException, LifecycleException {
		File file = new File(webappPath);		
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

index.jsp
```
<html>
	<body>
		<h1><%out.println("Embedded Tomcat Jsp Example");%></h1>
	</body>
</html>
```

## Dependencies
```
<!-- Embedded Tomcat -->
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-core</artifactId>
	<version>8.0.28</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-logging-juli</artifactId>
	<version>8.0.28</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
	<version>8.0.28</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jasper</artifactId>
	<version>8.0.28</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jasper-el</artifactId>
	<version>8.0.28</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jsp-api</artifactId>
	<version>8.0.28</version>
</dependency>

<!-- JSP Stadard Tag Library -->
<dependency>
	<groupId>jstl</groupId>
	<artifactId>jstl</artifactId>
	<version>1.2</version>
</dependency>
```