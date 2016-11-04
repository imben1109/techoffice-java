# Spring Bean Property Example

Spring is a Inversion of Control Container. In this example, it would show you how to use XML to configure and declare Spring bean for use. 
In this example, it would create a spring bean and set a value for its property.

bean.xml (XML configuration of Spring Application)
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context" xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

	<bean class="com.ittechoffice.example.HelloWorldExample">
		<property name="message" value="Hello! This is a Spring Hello World Example By Tech Office - Java!" />
	</bean>

</beans>
```

It declare a HelloWorldExample Bean in Spring. Once Spring Application starts, Spring would create a bean of HelloWorldExample and set the value of message. 

HelloWorldExample.java (Main Program and Spring Bean Definition)
```
public class HelloWorldExample {
	
	private String message;
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	
	/**
	 * Main Program 
	 * @param args
	 */
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorldExample helloWorldExample = context.getBean(HelloWorldExample.class);
		System.out.println(helloWorldExample.getMessage());
	}
}

```
It would start a Spring Application and retrieve Spring Bean of HelloWorldExample. 


pom.xml (Dependencies)
```
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-core</artifactId>
	<version>4.3.0.RELEASE</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
	<version>4.3.0.RELEASE</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-beans</artifactId>
	<version>4.3.0.RELEASE</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context-support</artifactId>
	<version>4.3.0.RELEASE</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-expression</artifactId>
	<version>4.3.0.RELEASE</version>
</dependency>
```