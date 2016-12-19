package com.techoffice.oracle.client.util;

import org.apache.commons.lang3.StringUtils;

public class SqlUtil {
	
	public static String formatSql(String sql){
		sql = trimLastSemicolon(sql);
		return sql;
	}
	
	public static String trimLastSemicolon(String sql){
		return StringUtils.removeEnd(sql, ";");
	}
}
