package com.techoffice.database.convertor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;

import com.techoffice.database.config.JdbcTypeConfig;
import com.techoffice.database.config.annoation.JdbcTypeMapping;
import com.techoffice.database.model.Field;

public class JdbcTypeConvertor {

	private static ScriptEngineManager manager = new ScriptEngineManager();
	private static ScriptEngine scriptEngine = manager.getEngineByName("js");
	private static Map<String, String> javaTypeMappingCachedMap = new ConcurrentHashMap<String, String>();
	
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
	
	public static synchronized String getJavaFullType(Field field){
		String javaFullType = "";
		String jdbcType = field.getJdbcType();
		javaFullType = javaTypeMappingCachedMap.get(jdbcType);
		if (StringUtils.isNotEmpty(javaFullType)){
			return javaFullType;
		}
		JdbcTypeMapping jdbcTypeMapping = JdbcTypeConfig.getJdbcTypeMapping(jdbcType);
		if (checkJdbcTypeMappingCondition(field, jdbcTypeMapping)){
			javaFullType = jdbcTypeMapping.javaFullType();
		}
		if (StringUtils.isEmpty(javaFullType)){
			throw new RuntimeException("Cannot find corresponding Java Type");
		}
		javaTypeMappingCachedMap.put(jdbcType, javaFullType);
		return javaFullType;
	}
	
	public static Field convertJavaType(Field field){
		String javaFullType = getJavaFullType(field);
		field.setJavaFullType(javaFullType);
		return field;
	}
	
	private JdbcTypeConvertor(){}
	
	public static void main(String[] args){
		Field field = new Field();
		field.setScale(100);
		getJavaFullType(field);
	}

}
