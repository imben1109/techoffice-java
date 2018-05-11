package com.techoffice.mybatis.h2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.techoffice.mybatis.h2.config.Config;


public class DatabaseUtil {

	private static Connection conn = null;
	
	private DatabaseUtil(){}
	
	public static Connection getConnection(){
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
