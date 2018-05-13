package com.techoffice.database.convertor;

import com.techoffice.database.model.Field;
import com.techoffice.util.StringUtil;

public class FieldConvertor {

	private FieldConvertor(){}
	
	public static Field convert(Class<?> configClass, Field field){
		String propertyName = StringUtil.upperUnderscoreToLowerCamel(field.getColumnName());
		field.setPropertyName(propertyName);
		field = JdbcTypeConvertor.convertJavaType(configClass, field);
		return field;
	}
	
}
