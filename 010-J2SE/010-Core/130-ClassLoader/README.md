# Class Loader
Java Classloader is part of Java Runtime Environment (JRE) which dynamically loads Java Class into Java Virutal Machine (JVM). Usually, classes are loaded on demand. A class with given name can only be loaded once by a given classloader.

* Bootstrap Class Loader (<Java Home>/jre/lib)
* Extensions Class Loader (<Java Home>/jre/lib/ext)
* System Class Loader (specified in class path)

# Servlet Container
Servlet Container is typically implemented by mutliple Class Loader.

## Tomcat 
Tomcat would install various Class Loader to allow different Web Application to run in same container. When a class loader is asked to load a particular class or resource, it would look for the class or resource in local repository, then delegrate the requests to its parent class loader.

* Bootstrap
* System
* Common
* Catalina
* Shared
* WebappX

# Reference
* https://en.wikipedia.org/wiki/Java_Classloader
* https://tomcat.apache.org/tomcat-5.5-doc/class-loader-howto.html