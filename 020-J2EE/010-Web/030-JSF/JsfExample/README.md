# Tomcat Jsf Example

**Prerequisite**
* Maven
* JSF 2.0
* Tomcat 7

## Managed Bean 

Managed Bean is regular Java Bean Class. It can be assessed by JSF Page. 

In JSF 1.x, managed bean has to register in faces-config.xml

In JSF 2.x, managed bean can be easily registered using annotations. 

The scope defines how long the bean live. 

* @RequestScoped	
* @NoneScoped	
* @ViewScoped	
* @SessionScoped	
* @ApplicationScoped	
* @CustomScoped	

By default, managed bean is request scoped. Request scoped mean the bean lives as long as the HTTP request/response. 

hello.xhtml
```
<h:form>
   <h:inputText value="#{helloBean.name}"></h:inputText>
   <h:commandButton value="Welcome Me" action="welcome"></h:commandButton>
</h:form> 
```
h:commandButton is exclusively to submit a POST form (not for page navigation). In this example, it would submit the data including helloBean to welcome.xhtml.

welcome.xhtml
```
<h:body bgcolor="white">
	<h2>JSF 2.0 Hello World Example - welcome.xhtml</h2>
	<h2>Welcome #{helloBean.name}</h2>
</h:body>
```
 
 HelloBean.java
 ```
 @ManagedBean
public class HelloBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
 ```