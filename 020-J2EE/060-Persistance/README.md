# Java Persistence API (JPA)
It is the API provided in J2EE for Object-Relational Mapping. The Domain Class in JPA is called Entity and Entity is managed by Entity Manager.

## Implementation
Java Persistence API (JPA) describes the Interface of Functionality. However, it requires different vendor to do implementation. 
* Hibernate 
* EclipseLink

## Entity Manager
Entity Manager is an instance which is used to interact with persistence context and manage the lifecycle of entity. There are two types of Entity Manager. One is Application-Managed Entity Manager while another is Container-Managed Entity Manger.
* Container-Managed Entity Manager
* Application-Managed Entity Manager

### Application-Managed Entity Manager
The Entity Manager is constructed and managed by Application. It use Application-Managed Transaction (EntityTransaction) rather than Java Transaction API (JTA) to manage transaction.

### Container-Managed Entity Manager
The Entity Manager is constructed and manged by Container (J2EE Container) such as JBoss, Websphere, etc. It use Java Transaction API to manage transction. It enables distributed transaction (transaction over mutliple resource such as database, JMS Broker). The Entity Manager (EntityManager) and Transaction (UserTransaction) can be autowired into Application by annotation.

# Reference
* https://docs.oracle.com/javaee/7/tutorial/partpersist.htm
* http://hibernate.org/
* https://docs.jboss.org/hibernate/entitymanager/3.5/reference/en/html/configuration.html