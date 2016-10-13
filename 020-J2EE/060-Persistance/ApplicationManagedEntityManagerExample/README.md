#Simple Persistence Example
- Entity Manager
	- Container-Managed Entity Manager
	- Application-Managed Entity Manager
- Persistence Units

In this example, it would demonstrate the Application-Managed Entity Manager using Hibernate as Java Persistence API Provider.

##Entity Manager
Entities are managed in Entity Manager. 
Container-Managed Entity Manager would automatically propagated to all application components while Application-Managed Entity Manager do not. 
Therefore, application components that use Container-Managed Entity Manager would use a single Java Transaction API (JTA) transaction. 

### Container-Managed Entity Manager

persistence.xml
```
<persistence-unit transaction-type="JTA">
```   

It would declare that the application use container-managed entity manager. The EntityManager and UserTransaction could inject into the application

```
@PersistenceContext
private EntityManager entityManager;

@Resouce
private UserTransaction userTransaction;
``` 

### Application-Manager Entity Manager 

persistence.xml
```
<persistence-unit transaction-type="RESOURCE_LOCAL">
```
   
It would declare that the application use application-managed entity manager. The Entity Manager is created and dispose in the application. The Entity Manager is created by the interface EntityManagerFactory which can be injected into the application.

```
@PersistenceUnit
private EntityManagerFactory entityManagerFactory;
```

Then, the entity manager and its transaction can be created and disposed in the application.

```
EntityManager entityManager = entityManagerFactory.createEntityManager()
entityManager.getTransaction().begin();
entityManager.getTransaction().commit();
``` 

## Persistence Units
It defines the Entity Class managed in Entity Manager. 

The persistence unit is defined in persistence.xml. 
For EJB project, it would be in META-INF directory
For WEB project, it would be in WEB-INF/classes/META-INF 

Besides, It would also define the JPA provider and DataSource.

# Example
Dependency: Jboss 7.1 AS

It provide Datasource named ExampleDS (H2 In-Memory Datasource) for this example.

persisence.xml
```

```
