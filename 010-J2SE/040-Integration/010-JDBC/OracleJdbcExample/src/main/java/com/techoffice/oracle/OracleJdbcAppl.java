package com.techoffice.oracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.techoffice.oracle.dao.ColumnDao;
import com.techoffice.oracle.model.Column;

public class OracleJdbcAppl {
	
	/**
	 * Main Program 
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = ColumnDao.getConnection();
		try {
			ColumnDao dao = new ColumnDao();
			List<Column> columns = dao.getColumnList(conn, "TEST");
			System.out.println(columns.size());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
