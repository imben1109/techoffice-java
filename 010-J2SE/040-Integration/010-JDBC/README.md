# Java Database Connectivitiy (JDBC)

It is an API which define how client access a database.

Sample Source Code to Insert Data into Database though JDBC.
```
Connection connection = DriverManager.getConnection(url, username, password);
Statement statement = connection.createStatement();
statement.executeUpdate("insert into temp_table values ('name1', 'name1')");
statement.close();
connection.close();
```

## Transaction
```
Connection connection = DriverManager.getConnection(url, username, password);
connection.setAutoCommit(false);
Statement statement = connection.createStatement();
statement.executeUpdate("insert into temp_table values ('name1', 'name1')");
connection.commit();
statement.close();
connection.close();
```
