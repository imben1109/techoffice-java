# Simple Local Stateless Session Beans (EJB) Example

Enterprise Java Bean is a component encapsulating the business logic. There are two types of EJB.
- Session Bean
- Message-driven Bean

## Session Bean
Session Bean can be classified as 
- Stateful
- Stateless

Session Bean can be accessed by 
- Local
- Remote

This example show a local stateless bean called by a web client.

## Example
In an enterprise application, there could be different module
- Web Module
- Ejb Module

In this example, there are three projects, Enterprise Application Project, Web Module and EJB Module. 

- Enterprise Application Project: SimpleApplication
- Web Module: SimpleWeb
- EJB Module: SimpleEjb

In **EJB Module**, it has an EJB called Test. 

**Interface**
```
@Local
public interface Test {
	public String sayHi();
}
```

**Implementation**
```
@Stateless
public class TestBean implements Test{

	@Override
	public String sayHi() {
		System.out.println("Hi");
		return "Hi";
	}

}

```

In **Web Module**, it has a servlet named SimpleEjbWebServlet. It would inject test for processing.

```
public class SimpleEjbWebServlet extends HttpServlet{
	
	@EJB
	Test test;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String hi = test.sayHi();
		out.println("<h1>The Bean Say: " + hi + "</h1>");
	}

}

```

