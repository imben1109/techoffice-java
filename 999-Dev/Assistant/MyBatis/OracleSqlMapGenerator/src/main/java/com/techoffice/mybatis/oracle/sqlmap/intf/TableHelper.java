package com.techoffice.mybatis.oracle.sqlmap.intf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.mybatis.oracle.config.Config;
import com.techoffice.mybatis.oracle.model.TableColumn;

public class TableHelper {
	
	public static List<TableColumn> getTableColumnList(String tableName){
		List<TableColumn> tableColumnList = new ArrayList<TableColumn>();
		String url = Config.getOracleConnectionUrl();
		String userName = Config.getOracleConnectionUser();
		String password = Config.getOracleConnectionPassword();
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "select column_name, data_type from user_tab_cols where upper(table_name) = upper(?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, tableName);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
				String columnName = resultSet.getString("column_name");
				String dataType = resultSet.getString("data_type");
				System.out.println(columnName + " " + dataType);
				TableColumn tableColumn = new TableColumn();
				tableColumn.setColumnName(columnName);
				tableColumn.setDataType(dataType);
				tableColumnList.add(tableColumn );
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableColumnList;
	}
	
}
