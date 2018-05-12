package com.techoffice.h2.util;

import java.util.List;

import com.techoffice.database.util.DaoUtil;
import com.techoffice.h2.connection.H2DatabaseConnection;

public class H2DaoUtil {

	public static <T> List<T> list(Class<T> clazz, String query){
		return DaoUtil.list(H2DatabaseConnection.class, clazz, query);
	}
}
