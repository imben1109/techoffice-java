package com.techoffice.oracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.oracle.dao.ColumnDao;
import com.techoffice.oracle.generator.HtmlFormGenerator;
import com.techoffice.oracle.generator.PackageBodyGenerator;
import com.techoffice.oracle.generator.PackageSpecGenerator;
import com.techoffice.oracle.generator.PojoGenerator;
import com.techoffice.oracle.generator.SqlMapGenerator;
import com.techoffice.oracle.model.Column;
import com.techoffice.oracle.util.PojoUtil;

public class OracleJdbcAppl {
	
	/**
	 * Main Program 
	 * @param args
	 */
	public static void main(String[] args) {
		String tableName = "TEST";
		List<Column> columns  = new ArrayList<Column>();
		Connection conn = ColumnDao.getConnection();
		try {
			ColumnDao dao = new ColumnDao();
			columns = dao.getColumnList(conn, tableName);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		String pojo = PojoGenerator.generate(columns);
		String packageSpec = PackageSpecGenerator.generatePackageSpec(tableName, columns);
		String packageBody = PackageBodyGenerator.generate(tableName, columns);
		String sqlMap = SqlMapGenerator.generate(tableName, columns);
		String htmlForm = HtmlFormGenerator.generate(tableName, columns);
		System.out.println(pojo);
		System.out.println(packageSpec);
		System.out.println(packageBody);
		System.out.println(sqlMap);
		System.out.println(htmlForm);
	}
}
