package com.techoffice.database.dao.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.techoffice.database.dao.connection.DatabaseConnection;
import com.techoffice.database.dao.registry.DatabaseConnectionRegistry;

public class SqlUtil {

	private SqlUtil(){}
	
	public static void execute(Class<? extends DatabaseConnection> databaseConnectionClass, String sql){
		DatabaseConnection databaseConnection = DatabaseConnectionRegistry.getDatabaseConnection(databaseConnectionClass);
		Connection connection =  databaseConnection.getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void createTable(Class<? extends DatabaseConnection> databaseConnectionClass, String sql){
		execute(databaseConnectionClass, sql);
	}
	
	public static void dropTable(Class<? extends DatabaseConnection> databaseConnectionClass, String tableName){
		String sql = "DROP TABLE " + tableName;
		execute(databaseConnectionClass, sql);
	}
	
}
