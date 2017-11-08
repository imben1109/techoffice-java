# Spring ActiveMQ Example

This is an Example of Spring Application embedded ActivieMQ.

Spring Application has a Messaging Listener for receiving message (tcp://localhost:61616 destination: destination). 
Spring Application use Spring JmsTemplate to send message to the port.
The Listener receive the message and print the content on the console. 

## PooledConnectionFactory
It implements javax.jms.ConnectionFactory which can be used to create connection (connection can be used to create session and then create Message to Destination of MQ Broker.) in JMS Programming Model.

# Reference
* https://wordpress.com/page/techofficejava.wordpress.com/98