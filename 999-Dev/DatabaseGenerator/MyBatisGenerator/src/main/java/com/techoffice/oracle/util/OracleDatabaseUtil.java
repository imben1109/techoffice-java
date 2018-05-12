package com.techoffice.oracle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.techoffice.oracle.config.Config;

public class OracleDatabaseUtil {

	private static Connection conn = null;
	
	private OracleDatabaseUtil(){}
	
	public static Connection getConnection(){
		if (conn == null){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(Config.getOracleConnectionUrl(), 
						Config.getOracleConnectionUser(), 
						Config.getOracleConnectionPassword());
			} catch (SQLException e) {
				throw new RuntimeException("Cannot create database connection", e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Cannot create database connection", e);
			}
		}
		return conn;
	}
	
}
