package com.techoffice.database.dao.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Entity {

	private String javaClassName;
	private String tableName;
	private List<Field> fieldList;
	private Key primaryKey;
	private Map<Object, Object> metaMap = new HashMap<Object, Object>();
	
	public String getJavaClassName() {
		return javaClassName;
	}
	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<Field> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}
	public Key getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Key primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getUncaptialJavaClassName(){
		return StringUtils.uncapitalize(javaClassName);
	}
	public Map<Object, Object> getMetaMap() {
		return metaMap;
	}
	public void setMetaMap(Map<Object, Object> metaMap) {
		this.metaMap = metaMap;
	}

	
}
