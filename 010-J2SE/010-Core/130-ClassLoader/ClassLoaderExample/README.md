# Java Classloader 
It is part of Java Runtime environment (JRE) that dynamically loads Java Classes into Java Virtual Machine (JVM). 

When JVM  is started, three class loaders are used
* Bootstrap class laoder (path: <JAVA_HOME>/jre/lib)
* Extensions class laoder (path: <JAVA_HOME/lib/ext>)
* System class loder (specified in java class path)

## Example

## Class Loaders in J2EE Application Server
J2EE application Servers typically load classes from deployed WAR or EAR archive. The J2EE container, EJB Container, Servlet Container are typcially implemented with multiple classloaders.

									  Bootstrap Class Loader 
												 ^
												 |
										System Class Loader
												 ^
												 |
									 Shared Chain Class Loader
												 ^
												 |
								--------------------------------
								|                       	   |
						Common Class Loader            MBean Class Loader
								^
								|
					   Connector Class Loader
								^
								|
				---------------------------------------
				|                                     |
	Application Class Loader         	Life Cycle Module Class Loader
			    ^
			    |
	      Web Class Loader
				^
				|
	JSP Engine Class Loader