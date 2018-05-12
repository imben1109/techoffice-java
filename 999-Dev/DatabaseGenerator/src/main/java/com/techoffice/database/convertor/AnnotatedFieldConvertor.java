package com.techoffice.database.convertor;

import com.techoffice.database.model.Field;
import com.techoffice.database.util.FieldUtil;

public class AnnotatedFieldConvertor {

	public static Field convert(Object object){
		String columnName = FieldUtil.getColumnName	(object);
		String jdbcType = FieldUtil.getJdcbType(object);
		Integer precision = FieldUtil.getPrecisionProperty(object);
		Integer scale = FieldUtil.getScaleProperty(object);
		Field filed = new Field();
		filed.setColumnName(columnName);
		filed.setJdbcType(jdbcType);
		filed.setPrecision(precision);
		filed.setScale(scale);
		return null;
	}
}
