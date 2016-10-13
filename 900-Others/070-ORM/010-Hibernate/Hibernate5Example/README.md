# Hibernate 5 Example

## Hiberante 
Hibernate is a Object-Relational Mapping (ORM) Framework. It provide a way to manipulate data from database to java application.

## Example
This example demonstrate the Hibernate native way for ORM.
Hibernate expose a Session object which would be used for operating with Hibernate.

```
final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();

try {
	SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	Session session = sessionFactory.openSession();
}catch (Exception e) {
	// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
	// so destroy it manually.
	StandardServiceRegistryBuilder.destroy(registry);
	e.printStackTrace();
}
```

The Hibernate Config is stored in hibernate.cfg.xml.

hibernate.cfg.xml
```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration SYSTEM 
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
   <session-factory>
   <property name="hibernate.dialect">org.hibernate.dialect.H2Dialect</property>
   <property name="hibernate.connection.driver_class">org.h2.Driver</property>

   <!-- Assume test is the database name -->
   <property name="hibernate.connection.url">jdbc:h2:./test</property>
   <property name="hibernate.connection.username">sa</property>
   <property name="hibernate.connection.password"></property>
   
   <!-- Auto update the database schema -->
   <property name="hibernate.hbm2ddl.auto">update</property>
   
	<mapping resource="TestEntity.hbm.xml"/>

</session-factory>
</hibernate-configuration>
```

With the session object, java object could be easily inserted into database
```
session.beginTransaction();
TestEntity testEntity = new TestEntity();
testEntity.setName("Test Entity name 1");
testEntity.setDesc("Test Entity desc 1");
session.save(testEntity);
session.getTransaction().commit();
session.close();
```

Also, database reocrds could easily be queried and mapped to java object for further operation.
```
session = sessionFactory.openSession();
session.beginTransaction();
List<TestEntity> result = session.createQuery( "from TestEntity" ).list();
for ( TestEntity event : result ) {
    System.out.println( "TestEntity (" + event.getName() + ") : " + event.getDesc() );
}
session.getTransaction().commit();
session.close();			
```