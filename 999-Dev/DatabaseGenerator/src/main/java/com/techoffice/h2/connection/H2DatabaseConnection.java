package com.techoffice.h2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.techoffice.database.connection.DatabaseConnection;
import com.techoffice.database.registry.DatabaseConnectionRegistry;
import com.techoffice.h2.config.Config;


public class H2DatabaseConnection implements DatabaseConnection{

	private static Connection conn = null;
	
	private H2DatabaseConnection(){}
	
	static {
		H2DatabaseConnection instance = new H2DatabaseConnection();
		DatabaseConnectionRegistry.add(H2DatabaseConnection.class, instance);
	}
	
	public Connection getConnection(){
		if (conn == null){
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection(Config.getH2ConnectionUrl(), 
						Config.getH2ConnectionUser(), 
						Config.getH2ConnectionPassword());
			} catch (SQLException e) {
				throw new RuntimeException("Cannot create database connection", e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Cannot create database connection", e);
			}
		}
		return conn;
	}
	
}
