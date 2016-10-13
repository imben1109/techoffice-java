package com.ittechoffice.example.h2jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2JdbcAppl {
	
	private static final String url = "jdbc:h2:~/test";
	private static final String userName = "sa";
	private static final String password = "";
	
	public void createTableIfNotExist() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("create table if not exists temp_table (name varchar2, value varchar2) "); // stmt.executeQuery(sql);
		stmt.close();
		conn.close();
	}
	
	public void resetData() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from temp_table");
		stmt.executeUpdate("insert into temp_table values ('name1', 'name1')");
		stmt.executeUpdate("insert into temp_table values ('name2', 'name2')");
		stmt.close();
		conn.close();
	}
	
	public void count() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery("select count(1) from temp_table");
		resultSet.next();
		int count = resultSet.getInt(1);
		System.out.println("count: " + count);
		stmt.close();
		conn.close();
	}
	
	/**
	 * Main Program for H2JdbcAppl
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException{
		H2JdbcAppl h2JdbcAppl = new H2JdbcAppl();
		h2JdbcAppl.createTableIfNotExist();
		h2JdbcAppl.resetData();
		h2JdbcAppl.count();
	}
}
