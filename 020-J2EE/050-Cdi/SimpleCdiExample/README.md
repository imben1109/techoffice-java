# Simple Context and Dependency Inject (CDI)  Example 

A Java Class can be a container-managed object which could be injected different object in the J2EE platform (such as JBoss). 

**Server**: JBoss AS 7.1.1

An Application using CDI mush have a file named **beans.xml**. The beans.xml could be empty.
- For Web Application, the **beans.xml** is placed in **WEB-INF** directory
- For EJB Module, the **beans.xml** is placed in **META-INF** directory

This example contain two classes. One is servlet class named CdiServlet and another class is Test. Test is the bean which is used to inject to  CdiServlet.

```
public class CdiServlet extends HttpServlet{
	
	@Inject
	private Test test;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		test.sayHi();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>IT Tech CDI Example</h1>");
	}

}
```

```
public class Test{

	public void sayHi() {
		System.out.println("Hi");
	}

}

```





