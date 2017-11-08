# Spring Security Web Example

## Prerequisite
* Maven 3
* Eclipse Mars 4.5

## Dependencies
* Spring 4.3

## Example

## Spring Security Web 

Reference: https://ittechoffice.wordpress.com/2016/08/12/simple-spring-security-web-application-example/

DispatcherServlet-servlet.xml
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

