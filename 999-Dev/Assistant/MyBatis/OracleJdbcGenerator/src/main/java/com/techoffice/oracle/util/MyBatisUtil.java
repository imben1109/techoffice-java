package com.techoffice.oracle.util;

import com.techoffice.oracle.model.Column;

public class MyBatisUtil {
	public static String getJdbcType(Column column){
		if (column.getDataType().equals("NUMBER")){
			return "NUMERIC";
		}if (column.getDataType().equals("VARCHAR2")){
			return "VARCHAR";
		}
		return column.getDataType();
	}
}
