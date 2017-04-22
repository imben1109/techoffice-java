package com.techoffice.example;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * This is an Example of Spring Application embedded ActivieMQ.
 * 
 * Spring Application has a Messaging Listener for receiving message (tcp://localhost:61616 destination: destination). 
 * Spring Application use Spring JmsTemplate to send message to the port.
 * The Listener receive the message and print the content on the console. 
 * 
 * 
 * @author imben1109
 *
 */
@Component
public class Appl {
	
	public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void run(){
		System.out.println("Send Message");
		jmsTemplate.send("destination", new MessageCreator(){
			public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("Testing");
			}
		});
	}
	
	public static void main(String[] args) throws Exception{
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
