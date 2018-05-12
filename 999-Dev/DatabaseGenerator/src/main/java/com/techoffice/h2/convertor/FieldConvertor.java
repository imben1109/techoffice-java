package com.techoffice.h2.convertor;

import com.techoffice.database.model.Field;
import com.techoffice.database.util.FieldUtil;
import com.techoffice.h2.model.Columns;

public class FieldConvertor {

	public static Field convert(Columns columns){
		String columnName = FieldUtil.getColumnName	(columns);
		String jdbcType = FieldUtil.getJdcbType(columns);
		Integer precision = FieldUtil.getPrecisionProperty(columns);
		Integer scale = FieldUtil.getScaleProperty(columns);
		Field filed = new Field();
		filed.setColumnName(columnName);
		filed.setJdbcType(jdbcType);
		filed.setPrecision(precision);
		filed.setScale(scale);
		return null;
	}
}
