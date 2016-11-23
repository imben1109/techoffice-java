# Embedded Tomcat Hello World Example

## Example

This example shows how to create a embedded tomcat with a custom servlet. It would reponse "Tomcat Test" for all request.
```
public class Appl {
	public static void main(String[] args) throws LifecycleException{
	    Tomcat tomcat = new Tomcat();
	    tomcat.setPort(8080);
        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

        Tomcat.addServlet(ctx, "Embedded", new HttpServlet() {
            @Override
            protected void service(HttpServletRequest req, HttpServletResponse resp) 
                    throws ServletException, IOException {
                
                Writer w = resp.getWriter();
                w.write("Tomcat Test\n");
                w.flush();
                w.close();
            }
        });

        ctx.addServletMapping("/*", "Embedded");

        
	    tomcat.start();
	    tomcat.getServer().await();

	}
}
```

## Dependencies
This example uses maven as a package manager. For embedded tomcat, it would include the following dependencies for pom.xml
```
<!-- Embedded Tomcat -->
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-core</artifactId>
	<version>7.0.57</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-logging-juli</artifactId>
	<version>7.0.57</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
	<version>7.0.57</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jasper</artifactId>
	<version>7.0.57</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jasper-el</artifactId>
	<version>7.0.57</version>
</dependency>
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jsp-api</artifactId>
	<version>7.0.57</version>
</dependency>
```