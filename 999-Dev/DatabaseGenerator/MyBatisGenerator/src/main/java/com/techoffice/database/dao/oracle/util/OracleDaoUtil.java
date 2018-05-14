package com.techoffice.database.dao.oracle.util;

import java.util.List;

import com.techoffice.database.dao.util.DaoUtil;
import com.techoffice.database.oracle.connection.OracleDatabaseConnection;

public class OracleDaoUtil {

	static {
		try {
			Class.forName("com.techoffice.h2.connection.H2DatabaseConnection");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> List<T> list(Class<T> instanceClazz, Class<?> daoClazz, String query){
		return DaoUtil.list(OracleDatabaseConnection.class, daoClazz, instanceClazz, query);
	}
}
