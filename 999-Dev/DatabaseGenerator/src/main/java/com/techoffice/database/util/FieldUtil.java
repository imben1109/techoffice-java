package com.techoffice.database.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;

import com.techoffice.database.config.annoation.ColumnName;
import com.techoffice.database.config.annoation.IsNullable;
import com.techoffice.database.config.annoation.JdbcType;
import com.techoffice.database.config.annoation.Precision;
import com.techoffice.database.config.annoation.Scale;

public class FieldUtil {

	private static String getAnnotatedProperty(Class<?> clazz, Class<? extends Annotation> annoataion){
		Field[] fields = clazz.getFields();
		for (int i=0; i<fields.length; i++){
			Field field = fields[i];
			if (field.getAnnotation(annoataion) != null){
				return field.getName();
			}
		}
		return null;
	}
	
	public static String getColumnName(Object object){
		String propertyName = getColumnNamePropertyName(object.getClass());
		try {
			Object property = PropertyUtils.getProperty(object, propertyName);
			if (property instanceof String){
				return (String) property;
			}
		}catch (Exception e){
			return null;	
		}
		return null;
	}
	
	public static String getColumnNamePropertyName(Class<?> clazz){
		return getAnnotatedProperty(clazz, ColumnName.class);
	}
	
	public static String getJdcbTypePropertyName(Class<?> clazz){
		return getAnnotatedProperty(clazz, JdbcType.class);
	}
	
	public static String getPrecisionPropertyName(Class<?> clazz){
		return getAnnotatedProperty(clazz, Precision.class);
	}
	
	public static String getScalePropertyName(Class<?> clazz){
		return getAnnotatedProperty(clazz, Scale.class);
	}
	
	public static String getIsNullablePropertyName(Class<?> clazz){
		return getAnnotatedProperty(clazz, IsNullable.class);
	}
}
