# Spring MVC Upload Example

## Prerequisite
* Tomcat 7
* Maven 3

## Dependencies
* Spring 4.3

## Example

## Spring Multipart Support
By default, Spring does not have multipart handling. In order to enable multipart support, **MultipartResolver** are required to define in Spring and use **Apache Commons fileUpload** to do the implementation. 

beans.xml
```
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	<property name="maxUploadSize" value="100000"/>
</bean>

``` 

Also, Apache Commons FileUpload is required to define in Maven POM.xml

pom.xml
```		
<dependency>
	<groupId>commons-fileupload</groupId>
	<artifactId>commons-fileupload</artifactId>
	<version>1.3.2</version>
</dependency>
```



