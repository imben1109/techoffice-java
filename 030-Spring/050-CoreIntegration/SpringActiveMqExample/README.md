# Spring ActiveMQ Example

This is an Example of Spring Application embedded ActivieMQ.

Spring Application has a Messaging Listener for receiving message (tcp://localhost:61616 destination: destination). 
Spring Application use Spring JmsTemplate to send message to the port.
The Listener receive the message and print the content on the console. 