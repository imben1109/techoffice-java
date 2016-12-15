# Named Query
In JPA, a query would be reused for many times. The query would be specified by a name and placed in XML file or Annotation for reuse. 

# JPA Named Query Example
In this example, the query would be placed in the xml files. Then the querys would be reused. Java Persistence Query Language (JPQL) would be used for Named Query. If Native Query is preferred, Named Native Query would be used instead. 

* Native SQL
* JPQL

## Persistence.xml

The Configuration for JPA. 
```
<persistence
	version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence 
		http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	
	<!-- 
		It define one or more persistence units. non-JTA-aware data source are used in this example.
		JTA-Datasource would used configured in this file with tag <jta-data-source>.
	 -->
	 
	<persistence-unit name="techoffice" transaction-type="RESOURCE_LOCAL">
		<mapping-file>META-INF/jpql/querys.xml</mapping-file>
		<mapping-file>META-INF/native/querys.xml</mapping-file>		
		<class>com.techoffice.example.hibernatejpa.model</class>
		<properties>
	        <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
			<property name="javax.persistence.jdbc.driver" value="org.h2.Driver" />
			<property name="javax.persistence.jdbc.url" value="jdbc:h2:~/test"/>
			<property name="javax.persistence.jdbc.user" value="sa"/>
			<property name="javax.persistence.jdbc.password" value=""/>
			<property name="hibernate.connection.pool_size" value="1"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
			<property name="show_sql" value="true"/>
			<property name="hibernate.temp.use_jdbc_metadata_defaults" value="false"/>
		</properties>
	</persistence-unit>
</persistence>
```
