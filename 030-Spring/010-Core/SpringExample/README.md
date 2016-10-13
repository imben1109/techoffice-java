# Spring Example 

## Prerequisite
* Maven 3
* Eclipse Mars.1 Release (4.5.1)

## Dependencies
* Spring 4.3

## Example
Spring home page: https://spring.io/

Spring is inversion of control framework for Java. 

This Example demonstrates the Hello World Example of Spring.

* **SimpleSpringAppl**
 * Simple Spring Example Using XML Configuration
* **SimpleSpringApplJavaBasedConfig**
 * Simple Spring Example Using Java Based Configuration
* **SimpleSpringApplWithAnnotation**
 * Simple Spring Example With Annotation Configuration
* **SimpleSpringApplWithComponentScan**
 * Simple Spring Example With Auto-Scan Configuration

## Spring 

In Spring, the object are managed by the SPring IoC container represented by **ApplicationContext** (Interface). 

**ClassPathXmlApplicationContext**

ClassPathXmlApplicationContext is an implementation of ApplicationContext for standalone XML application context. 



### Annotation Configuration

**@Autowired**

Autowired annotation provides the same feature of property in configuration.

**@Component**

Component annotation indicates that the class is Spring bean. (@Since Spring 2.5)

**@Configuration**

Configuration indicates that the class is a source of bean definition of Spring IoC container.

**@Bean**

Bean annotation explicity declare a sigle bean. Noted that the declaration is not in Class Level. (@Since Spring 3.0)
