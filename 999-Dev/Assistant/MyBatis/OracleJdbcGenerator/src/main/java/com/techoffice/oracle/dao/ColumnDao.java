package com.techoffice.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.oracle.config.Config;
import com.techoffice.oracle.model.Column;

public class ColumnDao {
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(Config.getOracleConnectionUrl(), 
					Config.getOracleConnectionUser(), 
					Config.getOracleConnectionPassword());
		} catch (SQLException e) {
			throw new RuntimeException("Cannot create database connection");
		}
		return conn;
	}
	
	public List<Column> getColumnList(Connection conn, String tableName){
		List<Column> columns = new ArrayList<Column>();
		String query = "SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, DATA_LENGTH, NULLABLE, DECODE(DATA_SCALE, NULL, 999, DATA_SCALE) DATA_SCALE FROM USER_TAB_COLS WHERE TABLE_NAME = '"+ tableName +"'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()){
				String columnName = resultSet.getString(2);
				String dataType = resultSet.getString(3);
				int dataLength = resultSet.getInt(4);
				String nullable = resultSet.getString(5);
				int dataScale = resultSet.getInt(6);
				Column column = new Column();
				column.setTableName(tableName);
				column.setColumnName(columnName);
				column.setDataType(dataType);
				column.setDataLength(dataLength);
				column.setNullable(nullable);
				column.setDataScale(dataScale);
				if (isIndexColumn(conn, tableName, columnName)){
					column.setIndexColumn(true);
				}else{
					column.setIndexColumn(false);
				}
				columns.add(column);
			}
		} catch (SQLException e) {
			System.err.println("Fail to query: " + query);
			e.printStackTrace();
		}
		return columns;
	}
	
	public boolean isIndexColumn(Connection conn, String tableName, String columnName){
		boolean isIndex = false;
		String queryTemplate = "SELECT COUNT(1) FROM USER_IND_COLUMNS WHERE TABLE_NAME = ''{0}'' AND COLUMN_NAME = ''{1}''";
		String query = MessageFormat.format(queryTemplate,  tableName, columnName);
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()){
				int count = resultSet.getInt(1);
				if (count > 0 ){
					isIndex = true;
				}
			}
		} catch (SQLException e) {
			System.err.println("Fail to query: " + query);
			e.printStackTrace();
		}
		return isIndex;
	}
}
