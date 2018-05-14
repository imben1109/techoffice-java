package com.techoffice.database.dao.convertor;

import com.techoffice.database.dao.model.Field;
import com.techoffice.database.dao.util.StringUtil;

public class FieldConvertor {

	private FieldConvertor(){}
	
	public static Field convert(Class<?> configClass, Field field){
		String propertyName = StringUtil.upperUnderscoreToLowerCamel(field.getColumnName());
		field.setPropertyName(propertyName);
		field = JdbcTypeConvertor.convertJavaType(configClass, field);
		return field;
	}
	
}
