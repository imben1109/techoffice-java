package com.techoffice.mybatis.oracle.util;

import com.google.common.base.CaseFormat;
import com.techoffice.mybatis.oracle.model.TableColumn;

public class SqlMapVariableHelper {
	
	public static String getVariable(TableColumn tableColumn){
		String javaVariable = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableColumn.getColumnName());
		String sqlMapVaraible = "#{" +javaVariable +", jdbcType=" + JdbcTypeMapper.get(tableColumn.getDataType()) + "}";
		return sqlMapVaraible;
	}
}
