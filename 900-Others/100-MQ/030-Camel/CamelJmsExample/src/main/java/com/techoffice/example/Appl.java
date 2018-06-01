package com.techoffice.example;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Appl {
	public static void main(String[] args) throws Exception{
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

        // JMS Template 
        ProducerTemplate template = context.createProducerTemplate();
        for (int i = 0; i < 10; i++) {
            template.sendBody("test-jms:queue:test.queue", "Test Message: " + i);
        }
        
        Thread.sleep(1000);
        context.stop();

	}
}
