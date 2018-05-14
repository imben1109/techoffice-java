package com.techoffice.database.oracle.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.techoffice.database.dao.connection.DatabaseConnection;
import com.techoffice.database.dao.registry.DatabaseConnectionRegistry;
import com.techoffice.database.oracle.config.OracleConfig;

public class OracleDatabaseConnection implements DatabaseConnection{

	private static Connection conn = null;
	
	private OracleDatabaseConnection(){}
	
	static {
		OracleDatabaseConnection instance = new OracleDatabaseConnection();
		DatabaseConnectionRegistry.add(OracleDatabaseConnection.class, instance);
	}
	
	public Connection getConnection(){
		if (conn == null){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(OracleConfig.getOracleConnectionUrl(), 
						OracleConfig.getOracleConnectionUser(), 
						OracleConfig.getOracleConnectionPassword());
			} catch (SQLException e) {
				throw new RuntimeException("Cannot create database connection", e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Cannot create database connection", e);
			}
		}
		return conn;
	}
	
}
