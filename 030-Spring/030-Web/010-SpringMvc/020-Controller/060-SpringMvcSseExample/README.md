# Spring MVC Server Send Event Example

## Prerequisite

* Tomcat 7
* Maven 3

## Dependencies
* Spring 4.3

## Example

## Spring SseEmitter (Server Sent Event)
web.xml
```
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            http://java.sun.com/xml/ns/javaee
            http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
    version="3.0">

```

beans.xml
```
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="
   http://www.springframework.org/schema/beans     
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
   http://www.springframework.org/schema/context 
   http://www.springframework.org/schema/context/spring-context-3.0.xsd
   http://www.springframework.org/schema/mvc
   http://www.springframework.org/schema/mvc/spring-mvc.xsd">
      
	<context:component-scan base-package="com.ittechoffice.example" />
	
	<mvc:annotation-driven/> 
	
	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/jsp/" />
		<property name="suffix" value=".jsp" />
	</bean>
	<bean id="sseEmitter" class="org.springframework.web.servlet.mvc.method.annotation.SseEmitter"/>
</beans>
```

SimpleController.java
```
@Controller
public class SimpleController {
		
	@Autowired
    private SseEmitterManager sseEmitterManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model){
		return "home";		
	}
	
	@RequestMapping(value ="/emit")
	public SseEmitter  handle() {
	    return sseEmitterManager.createEmitter();
	}

	@RequestMapping(value="/send", method = RequestMethod.GET)
	@ResponseBody
	public String send(@RequestParam("message") String message) throws IOException{
		sseEmitterManager.send(message);
		return message;
	}
	
}
```

```
public class SseEmitterManager {
	private List<SseEmitter> sseEmitters;
	
	public SseEmitterManager(){
		sseEmitters = new ArrayList<SseEmitter>();
	}
	
	public SseEmitter createEmitter(){
		SseEmitter sseEmitter = new SseEmitter();
		SseEmitterPurgeJob job = new SseEmitterPurgeJob(sseEmitter);
		sseEmitter.onCompletion(job);
		sseEmitter.onTimeout(job);
		sseEmitters.add(sseEmitter);
		System.out.println(String.format("Now, there are %d emitters", sseEmitters.size()));
		return sseEmitter;
	}
	
	public void send(String message) throws IOException{
		for (SseEmitter sseEmitter: sseEmitters){
			sseEmitter.send(message);
		}
	}
	
	private class SseEmitterPurgeJob implements Runnable {
		private SseEmitter sseEmitter;
		public SseEmitterPurgeJob(SseEmitter sseEmitter){
			this.sseEmitter = sseEmitter;
		}
		@Override
		public void run(){
			System.out.println("SSE Emitter Timeout / Completed");
			sseEmitters.remove(sseEmitter);
		}
	}
}

```

home.jsp
```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script>
		function sendMessage() {
			var input = document.getElementById("input").value;
			var xhttp = new XMLHttpRequest();
			xhttp.open("GET", "send?message=" + input, true);
			xhttp.send();
		}
	</script>
</head>
<body>
	<h1>Spring MVC Server Sent Event Example</h1>
	<input id="input"/><button id="sendBtn" type="button" onclick="sendMessage()">Send</button>

	<div id="message"></div>
	<script>
		var source = new EventSource("emit");
		source.onmessage = function(event) {
		    document.getElementById("message").innerHTML += event.data + "<br>";
		};
	</script>
</body>
</html>
```