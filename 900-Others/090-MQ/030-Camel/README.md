# Apache Camel Example
Camel is a rule-based routing and mediation engine which implements the Enterprise Integration Patterns (EIP).

## CamcelContext 
CamcelContext represet a Camel Routing Enviroment which is very similar to Spring's ApplicationContext.

```
CamelContext context = new DefaultCamelContext();
context.start();
context.stop();
```

In CamelContext, It would add different components and rules to implement routing functionalities.
```
CamelContext context = new DefaultCamelContext();
        
// Configure JMS Component and Route
ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
context.addComponent("test-jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
context.addRoutes(new RouteBuilder() {
	public void configure() {
		from("test-jms:queue:test.queue").to("file://test");
	}
});

context.start();
```

# Reference
* http://camel.apache.org/