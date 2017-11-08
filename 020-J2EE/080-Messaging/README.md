# Java Message Service (JMS) API
Messaging is a technology for synchronous or asynchronous information exchange between distributed application. J2EE provide Java Messaging Service (JMS) API that allows application create, send, receive and read message. The message in JMS can be Queue or Topic depending on the Messaging Model.

* Point-to-point Model (Queue)
* Publush-Subscribe Model (Topic)

## Point-to-Point Model
Each message has only one consumer and the receiver would response the successful processing once the process is completed. The Queue would be kept until one consumer is available that can process the queue.

## Publish-Subscribe Model
Each message has multiple consumers. The consumer can only receive the message after it subscribes.

## Implementation of JMS
* ActiveMQ

# Reference
* https://techofficejava.wordpress.com/j2ee-messaging/