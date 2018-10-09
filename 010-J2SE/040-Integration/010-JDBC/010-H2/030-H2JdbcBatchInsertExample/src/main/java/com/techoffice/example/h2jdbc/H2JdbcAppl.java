package com.techoffice.example.h2jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2JdbcAppl {
	
	private static final int NUM_RECORD = 10000; 
	private static final String url = "jdbc:h2:~/test";
	private static final String userName = "sa";
	private static final String password = "";
	
	public void createTableIfNotExist() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("create table if not exists temp_table (name varchar2, value varchar2) "); 
		stmt.close();
		conn.close();
	}
	
	public void resetData() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from temp_table");
		stmt.close();
		conn.close();
	}
	
	public void insertData() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement stmt = conn.createStatement();
		for (int i=0; i<NUM_RECORD; i++){
			stmt.executeUpdate("insert into temp_table values ('name" + i +"', 'name"+ i +"')");
			conn.commit();
		}
		stmt.close();
		conn.close();
	}
	
	public void batchInsertData() throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, password);
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		for (int i=0; i<NUM_RECORD; i++){
			stmt.addBatch("insert into temp_table values ('batch_name" + i +"', 'batch_name"+ i +"')");
		}
		stmt.executeBatch();
		conn.commit();
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
		long start = System.currentTimeMillis();
		h2JdbcAppl.insertData();
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		h2JdbcAppl.batchInsertData();
		System.out.println(System.currentTimeMillis() - start);

		h2JdbcAppl.count();
	}
}
