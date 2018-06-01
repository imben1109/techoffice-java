# Jetty JSP Example

## Jetty 
Jetty is a Java HTTP Server and a Servert Container.

## Jetty JSP 
The JSP file must be compiled into java class. 
JDK provide JavaC built-in complier. In order to disable it, the system property would be required to set in runtime. 
```
System.setProperty("org.apache.jasper.compiler.disablejsr199","false");
```
Then Jetty would use the default Eclipse JDT compiler.

