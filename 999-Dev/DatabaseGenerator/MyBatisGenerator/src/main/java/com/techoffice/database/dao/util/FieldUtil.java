package com.techoffice.database.dao.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;

import com.techoffice.database.dao.config.annoation.ColumnName;
import com.techoffice.database.dao.config.annoation.DataLength;
import com.techoffice.database.dao.config.annoation.IsNullable;
import com.techoffice.database.dao.config.annoation.JdbcType;
import com.techoffice.database.dao.config.annoation.Precision;
import com.techoffice.database.dao.config.annoation.Scale;

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
			}else {
				throw new RuntimeException("Invalid Date Type of annotation: " + annoataion.getName() + " for " + object.getClass().getName());
			}
		}catch (Exception e){
			throw new RuntimeException(e);	
		}
	}
	
	private static Integer getIntegerProperty(Object object, Class<? extends Annotation> annoataion){
		String propertyName = getAnnotatedPropertyName(object.getClass(), annoataion);
		try {
			Object property = PropertyUtils.getProperty(object, propertyName);
			if (property instanceof Integer){
				return (Integer) property;
			}else {
				throw new RuntimeException("Invalid Date Type of annotation: " + annoataion.getName() + " for " + object.getClass().getName());
			}
		}catch (Exception e){
			throw new RuntimeException(e);	
		}
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
	
	public static Integer getDataLengthProperty(Object object){
		return getIntegerProperty(object, DataLength.class);
	} 
	
	public static Integer getScaleProperty(Object object){
		return getIntegerProperty(object, Scale.class);
	}
	
	public static String getIsNullablePropertyName(Object object){
		return getStringProperty(object, IsNullable.class);
	}
	

}
