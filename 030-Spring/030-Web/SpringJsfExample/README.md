# Spring JSF Example

## Prerequisite

* Maven 3
* Tomcat 7


## Example 

It is an example of Spring Jsf Integration. 


## Spring "ContextLoaderListener"

The below codes are required to add in web.xml. With these configuration, the Spring Context would be set up when Web Application start.

```
<listener>
  <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```

```
<context-param>
  <param-name>contextConfigLocation</param-name>
  <param-value>/WEB-INF/applicationContext.xml</param-value>
</context-param>
```

Create a Spring config file, applicationContext.xml. The below is an example.

```
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context-3.1.xsd">

	<context:component-scan base-package="com.ittechoffice" />

</beans>

```

## JSF 

The below codes are required to add in faces-context.xml 

```
	<application>
		<el-resolver>
    		    org.springframework.web.jsf.el.SpringBeanFacesELResolver
		</el-resolver>
  	</application>
```
