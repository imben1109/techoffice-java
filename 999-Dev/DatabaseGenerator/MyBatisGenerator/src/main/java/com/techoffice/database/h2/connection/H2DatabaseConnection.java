package com.techoffice.database.h2.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.techoffice.database.dao.connection.DatabaseConnection;
import com.techoffice.database.dao.registry.DatabaseConnectionRegistry;
import com.techoffice.database.h2.config.H2Config;


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
				conn = DriverManager.getConnection(H2Config.getH2ConnectionUrl(), 
						H2Config.getH2ConnectionUser(), 
						H2Config.getH2ConnectionPassword());
			} catch (SQLException e) {
				throw new RuntimeException("Cannot create database connection", e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Cannot create database connection", e);
			}
		}
		return conn;
	}
	
}
