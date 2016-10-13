# Hibernate 4 Example

## Prerequisite

* Maven 3
* Eclipse Mars

### Dependencies
* Hibernate 4.3

## Hibernate

Hibernate is a Object-Relational Mapping (ORM) Framework. It provide a way to manipulate data from database to java application. 

Hibernate provide two standard way to access Hibernate. One is Hibernate Standard API and another is JPA. 

### Native Hibernate API.

The API is to use SessionFactory to obtain Session. After obtaining Session, you can apply various change to database such as create, update, delete operation.
 
Sample Code of Native API
```
Configuration configuration = new Configuration();
configuration.configure();

final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		.applySettings(configuration.getProperties()).build();
try {
	SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
	Session session = sessionFactory.openSession();
	session.close();
}catch (Exception e) {
	StandardServiceRegistryBuilder.destroy( registry );
	e.printStackTrace();
}
```

## JPA

Hibernate is also a JPA provider. Hibernate provide EntityManagerFactory to obtain EntityManager, so that JPA could be used in the application. 

```
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
EntityManager entityManager = entityManagerFactory.createEntityManager();
entityManager.close();
```

## Example List
There are two cases in this example.
 
* SessionFactoryExample
	* It demonstrates Hibernate Native API. Hibernate Native API works through SessionFactory and obtain Session From SessionFactory.
* EntityFactoryExample
	* It demonstrates Hibernate as a JPA provider.Hibernate provide EntityFactory to create EntityManager so JPA could be used in your Java Application.
	
