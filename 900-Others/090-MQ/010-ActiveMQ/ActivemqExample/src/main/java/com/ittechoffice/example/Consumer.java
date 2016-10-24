package com.ittechoffice.example;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer implements Runnable {

	public void run() {
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
			Connection connection = connectionFactory.createConnection();
			connection.start();
			 // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("TEST.FOO");
            // Create a MessageConsumer from the Session to the Topic or Queue
            MessageConsumer consumer= session.createConsumer(destination);
            //Wait for a message
            Message message = consumer.receive(1000);
            if (message instanceof TextMessage) {
            	TextMessage textMessage = (TextMessage) message;
            	String test = textMessage.getText();
            	System.out.println(test);
            }
            session.close();
            connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
