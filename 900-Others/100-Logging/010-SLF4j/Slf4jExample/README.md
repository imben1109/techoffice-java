# Simple Logging Facade for Java (Slf4J) Example
It serves as a simple facade for various logging framework such as java.util.logging, logback and log4j.

log4j-over-slf4j.jar 
It would make all log4j calls to be delegated to slf4j.

slf4j-log4j12.jar 
It would make all slf4j calls to to delegated to log4j.

In this example, slfj4j would be used for service facade (API) for logging message while log4j would be used as underlying logging framework of Implementation.

```
package com.ittechoffice.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Appl {
	final static Logger logger = LoggerFactory.getLogger(Appl.class);		
	public static void main(String[] args){
		logger.info("Hello Log4j Example");
	}
}
```