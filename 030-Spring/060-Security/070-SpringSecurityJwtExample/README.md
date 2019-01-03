# Spring Security Web Example

## Prerequisite
* Maven 3
* Eclipse Mars 4.5

## Dependencies
* Spring 4.3

## Example

## Spring Security Web 

Reference: https://ittechoffice.wordpress.com/2016/08/12/simple-spring-security-web-application-example/

beans.xml
```
<!-- Spring Security Config -->
<security:http auto-config="true">
	<!-- P.S. "**" means zero or more directories in the path -->
	<security:intercept-url pattern="/**" access="hasAuthority('ADMIN')"/>
</security:http>

<security:authentication-manager>
	<security:authentication-provider>
		<security:user-service>
			<security:user name="user" password="password" authorities="ADMIN"/>
		</security:user-service>
	</security:authentication-provider>
</security:authentication-manager>
```

web.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>Spring MVC Application</display-name>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/beans.xml</param-value>
  </context-param>
  <servlet>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/beans.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  <filter>
    <filter-name>springSecurityFilterChain</filter-name>
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>springSecurityFilterChain</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
</web-app>
```

DelegatingFilterProxy would provde the link between Spring Application Content and web.xml
Actually, security:http is FilterChainProxy which executes a list of Filter for HTTP. The below would be filters.
* ChannelProcessingFilter, support different protocol 
* SecurityContextPersistenceFilter, set up SecurityContent and any change to SecurityContent will copy to HttpServlet.
* ConcurrentSessionFilter, update SessionRegistry for request 
* UsernamePasswordAuthenticationFilter, CasAuthenticationFilter, BasicAuthenticationFilter, etc. , Authentication 
* SecurityContextHolderAwareRequestFilter [Optional]
* JaasApiIntegrationFilter [Optional]
* RememberMeAuthenticationFilter, The request with cookie information would do the authentication.
* AnonymousAuthenticationFilter, Anonymous Authentication
* ExceptionTranslationFilter, Catch any Spring Security Exception so that proper action would be triggered such as Http error response
* FilterSecurityInterceptor, Protect URIs access

 
