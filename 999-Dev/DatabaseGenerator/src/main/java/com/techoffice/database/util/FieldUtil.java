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

	private static String getAnnotatedPropertyName(Class<?> clazz, Class<? extends Annotation> annoataion){
		Field[] fields = clazz.getDeclaredFields();
		for (int i=0; i<fields.length; i++){
			Field field = fields[i];
			if (field.getAnnotation(annoataion) != null){
				return field.getName();
			}
		}
		return null;
	}
	
	private static String getStringProperty(Object object, Class<? extends Annotation> annoataion){
		String propertyName = getAnnotatedPropertyName(object.getClass(), annoataion);
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
	
	private static Integer getIntegerProperty(Object object, Class<? extends Annotation> annoataion){
		String propertyName = getAnnotatedPropertyName(object.getClass(), annoataion);
		try {
			Object property = PropertyUtils.getProperty(object, propertyName);
			if (property instanceof Integer){
				return (Integer) property;
			}
		}catch (Exception e){
			return null;	
		}
		return null;
	}
	
	public static String getColumnName(Object object){
		return getStringProperty(object, ColumnName.class);
	}
	
	public static String getJdcbType(Object object){
		return getStringProperty(object, JdbcType.class);
	}
	
	public static Integer getPrecisionProperty(Object object){
		return getIntegerProperty(object, Precision.class);
	}
	
	public static Integer getScaleProperty(Object object){
		return getIntegerProperty(object, Scale.class);
	}
	
	public static String getIsNullablePropertyName(Object object){
		return getStringProperty(object, IsNullable.class);
	}
}
