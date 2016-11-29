#H2 JDBC Example

**Reference**: https://ittechoffice.wordpress.com/2016/03/19/java-database-connectivity-jdbc/

**H2 Page**: http://www.h2database.com/html/main.html

* JDBC API is Java API to access data in relational database. 
* JDBC Driver implements the JDBC API to interact with relational database.
* H2 JDBC Driver: org.h2.Driver

**Sample Code for JDBC to execute SQL**
```
Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
Statement stmt = conn.createStatement();
stmt.executeUpdate(sql); // stmt.executeQuery(sql);
stmt.close()
conn.close()
```

