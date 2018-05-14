package com.techoffice.database.dao.convertor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;

import com.techoffice.database.dao.config.annoation.JdbcTypeMapping;
import com.techoffice.database.dao.config.annoation.JdbcTypeMappings;
import com.techoffice.database.dao.model.Field;

public class JdbcTypeConvertor {

	private static ScriptEngineManager manager = new ScriptEngineManager();
	private static ScriptEngine scriptEngine = manager.getEngineByName("js");
	private static Map<Field, String> javaTypeMappingCachedMap = new ConcurrentHashMap<Field, String>();
	
	private static synchronized boolean checkJdbcTypeMappingCondition(Field field, JdbcTypeMapping jdbcTypeMapping){
		if (StringUtils.isEmpty(jdbcTypeMapping.condition())){
			return true;
		}
		Boolean bool = true;
		scriptEngine.put("field", field);
		try {
			Object result = scriptEngine.eval(jdbcTypeMapping.condition());
			if (result instanceof Boolean){
				bool = (Boolean) result;
			}else {
				bool = false;
			}
		} catch (ScriptException e) {
			throw new RuntimeException(e);
		}
		scriptEngine.put("field", null);
		return bool;
	}
	
	public static synchronized String getJavaFullType(Class<?> configClass, Field field){
		String javaFullType = "";
		javaFullType = javaTypeMappingCachedMap.get(field);
		if (StringUtils.isNotEmpty(javaFullType)){
			return javaFullType;
		}
		JdbcTypeMapping jdbcTypeMapping = getJdbcTypeMapping(configClass, field);
		if (jdbcTypeMapping == null){
			throw new RuntimeException("Cannot find JDBC Type Mapping for " + field.getJavaFullType());
		}
		javaFullType = jdbcTypeMapping.javaFullType();
		if (StringUtils.isEmpty(javaFullType)){
			throw new RuntimeException("Cannot find corresponding Java Type for " 
					+ field.getJdbcType() + "(" + field.getPrecision() + "," + field.getScale() + ")");
		}
		javaTypeMappingCachedMap.put(field, javaFullType);
		return javaFullType;
	}
	
	public static Field convertJavaType(Class<?> clazz, Field field){
		String javaFullType = getJavaFullType(clazz, field);
		field.setJavaFullType(javaFullType);
		return field;
	}
	
	private JdbcTypeConvertor(){}
	
	public static JdbcTypeMappings getJdbcTypeMappings(Class<?> configClass){
		return configClass.getAnnotation(JdbcTypeMappings.class);
	}
	
	public static JdbcTypeMapping[] getJdbcTypeMappingArr(Class<?> configClass){
		JdbcTypeMappings jdbcTypeMappings = getJdbcTypeMappings(configClass);
		return jdbcTypeMappings.value();
	}
	
	public static JdbcTypeMapping getJdbcTypeMapping(Class<?> configClass, Field field){
		JdbcTypeMapping[] jdbcTypeMappingArr = getJdbcTypeMappingArr(configClass);
		for (int i=0; i<jdbcTypeMappingArr.length; i++){
			JdbcTypeMapping jdbcTypeMapping = jdbcTypeMappingArr[i];
			if (jdbcTypeMapping.value().equals(field.getJdbcType())){
				if (checkJdbcTypeMappingCondition(field, jdbcTypeMapping)){
					return jdbcTypeMapping;
				}
			}
		}
		return null;
	}

}
