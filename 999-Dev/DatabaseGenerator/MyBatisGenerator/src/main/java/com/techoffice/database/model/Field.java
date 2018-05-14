package com.techoffice.database.model;

import com.sun.xml.internal.ws.util.StringUtils;

public class Field {

	private String propertyName;
	private String jdbcType;
	private String javaFullType;
	private String columnName;
	private Integer precision;
	private Integer scale;
	private Integer dataLength;
	private boolean isNullable;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getJdbcType() {
		return jdbcType;
	}
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getPrecision() {
		return precision;
	}
	public void setPrecision(Integer precision) {
		this.precision = precision;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public String getJavaFullType() {
		return javaFullType;
	}
	public void setJavaFullType(String javaFullType) {
		this.javaFullType = javaFullType;
	}
	public Integer getDataLength() {
		return dataLength;
	}
	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}
	public boolean isNullable() {
		return isNullable;
	}
	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}
	public String getCaptialPropertyName(){
		String captialPropertyName = StringUtils.capitalize(this.propertyName);
		return captialPropertyName;
	}
	public String getJavaType() {
		int position = this.javaFullType.lastIndexOf(".");
		String javaType = this.javaFullType.substring(position+1);
		return javaType;
	}
	public String getJavaPackage() {
		int position = this.javaFullType.lastIndexOf(".");
		String javaPackage = this.javaFullType.substring(0, position);
		return javaPackage;
	}
	public String getColumnDefinition(){
		String columnDefinition = this.jdbcType;
		if (this.jdbcType.equals("NUMBER")){
			if (this.scale != null && this.precision != null ){
				columnDefinition = this.jdbcType + "(" + this.precision + "," + this.scale + ")";
			}
		}
		return columnDefinition;
	}
}
