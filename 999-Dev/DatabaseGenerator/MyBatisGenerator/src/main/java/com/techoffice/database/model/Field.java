package com.techoffice.database.model;

public class Field {

	private String propertyName;
	private String jdbcType;
	private String javaType;
	private String javaFullType;
	private String columnName;
	private Integer precision;
	private Integer scale;
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
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
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
	public boolean isNullable() {
		return isNullable;
	}
	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}
	public String getColumnDefinition(){
		String columnDefinition = this.jdbcType;
		if (this.jdbcType.equals("NUMBER")){
			columnDefinition = this.jdbcType + "(" + this.precision + "," + this.scale + ")";
		}
		return columnDefinition;
	}
}
