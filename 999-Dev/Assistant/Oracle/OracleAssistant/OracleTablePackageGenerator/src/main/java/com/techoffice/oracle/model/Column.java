package com.techoffice.oracle.model;

import com.techoffice.oracle.constant.ColumnConstant;

public class Column {
	private String tableName;
	private String columnName;
	private String dataType;
	private String nullable;
	private int pk;
	private int dataLength;
	private int dataScale;
	
	public Column(){
		
	}
	public Column(String columnName, String dataType, int dataLength){
		this.columnName = columnName;
		this.dataType = dataType;
	}
	public Column(String columnName, String dataType){
		this.columnName = columnName;
		this.dataType = dataType;
	}
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getDataLength() {
		return dataLength;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}
	public String getNullable() {
		return nullable;
	}
	public void setNullable(String nullable) {
		this.nullable = nullable;
	}
	
	public int getDataScale() {
		return dataScale;
	}
	public void setDataScale(int dataScale) {
		this.dataScale = dataScale;
	}
	public String toString(){
		if (ColumnConstant.DATE.equals(dataType)){
			return columnName + "	" + dataType;
		}
		return columnName + "	" + dataType ;
	}
}
