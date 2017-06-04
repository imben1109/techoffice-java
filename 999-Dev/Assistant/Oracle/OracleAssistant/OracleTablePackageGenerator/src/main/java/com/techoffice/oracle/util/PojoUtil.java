package com.techoffice.oracle.util;

import java.util.Date;

import com.google.common.base.CaseFormat;
import com.techoffice.oracle.constant.ColumnConstant;
import com.techoffice.oracle.model.Column;

public class PojoUtil {
	
	public static String getClassName(String tableName){
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
	}
	
	public static String getFieldName(String columnName){
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName);
	}
	
	public static Class<?> getClassType(Column column){
		if (ColumnConstant.VARCHAR2.equals(column.getDataType())){
			return String.class;
		}else if (ColumnConstant.NUMBER.equals(column.getDataType())
				&& column.getDataScale() == 0){
			return int.class;
		}else if (ColumnConstant.NUMBER.equals(column.getDataType())
				&& column.getDataScale() > 0){
			return double.class;
		}else if (ColumnConstant.DATE.equals(column.getDataType())){
			return Date.class;
		}	
		return null;
	}
	
	public static String getJavaType(Column column){
		Class<?> javaClass = getClassType(column);
		String javaType = javaClass.getName();
		if (javaType.equals("java.lang.String")){
			return "string";
		}
		return javaClass.getName();
	}
}
