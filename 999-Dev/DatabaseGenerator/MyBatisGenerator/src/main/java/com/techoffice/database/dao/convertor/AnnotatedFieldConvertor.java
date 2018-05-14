package com.techoffice.database.dao.convertor;

import java.util.ArrayList;
import java.util.List;

import com.techoffice.database.dao.model.Field;
import com.techoffice.database.dao.util.FieldUtil;

public class AnnotatedFieldConvertor {

	private AnnotatedFieldConvertor(){}
	
	public static Field convert(Object object){
		String columnName = FieldUtil.getColumnName	(object);
		String jdbcType = FieldUtil.getJdcbType(object);
		Integer precision = FieldUtil.getPrecisionProperty(object);
		Integer scale = FieldUtil.getScaleProperty(object);
		Integer dataLength = FieldUtil.getDataLengthProperty(object);
		Field filed = new Field();
		filed.setColumnName(columnName);
		filed.setJdbcType(jdbcType);
		filed.setPrecision(precision);
		filed.setScale(scale);
		filed.setDataLength(dataLength);
		return filed;
	}
	
	public static List<Field> convert(Class<?> configClass, List<?> objectList){
		List<Field> fieldList = new ArrayList<Field>();
		for (Object object: objectList){
			Field field = convert(object);
			field = FieldConvertor.convert(configClass, field);
			fieldList.add(field);
		}
		return fieldList;
	}
}
