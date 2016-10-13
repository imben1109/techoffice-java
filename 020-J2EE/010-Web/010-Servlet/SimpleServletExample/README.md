# Servlet Example

## Servlet 
Servlet is a Java Program that extends the abilities of a serever

## HttpServlet
HttpServlet is subclass of Servlet. It provide to Http Sevice to Http Request.
* doGet    - HTTP GET requests
* doPost   - HTTP POST requests
* doPut    - HTTP PUT requests
* doDelete - HTTP DELETE requests

Servlet Class
```
public class ItTechOfficeTestServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>IT Tech Office Test Servlet Example Update</h1>");
		
	}
}
```

The servlet configuration is requireed to define in web.xml in order to make the server to use the servlet for specified request. 

web.xml
```
<servlet>
	<servlet-name>ItTechOfficeTestServlet</servlet-name>
	<servlet-class>com.ittechoffice.testservlet.ItTechOfficeTestServlet</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>ItTechOfficeTestServlet</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```

