package com.techoffice.mybatis.generator;

import java.util.ArrayList;
import java.util.List;

import com.techoffice.freemarker.util.FreemakerUtil;
import com.techoffice.mybatis.model.Entity;
import com.techoffice.mybatis.model.Field;

public class TableGenerator {
	
	public static String generate(Entity entity){
		return FreemakerUtil.generate(TableGenerator.class, entity);
	}
	
	public static void main(String[] args){
		Entity entity = new Entity();
		entity.setJavaClassName("Test");
		entity.setTableName("TEST");
		List<Field> fieldList = new ArrayList<Field>();
		Field field = new Field();
		field.setColumnName("FIELD1");
		field.setJavaType("String");
		field.setJavaFullType("java.lang.String");
		field.setJdbcType("VARCHAR2");
		field.setPropertyName("field");
		fieldList.add(field);
		entity.setFieldList(fieldList);
		String content = generate(entity);
		System.out.println(content);
	}
}
