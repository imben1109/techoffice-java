package com.techoffice.oracle.client.model;

import com.techoffice.oracle.client.constant.ColumnConstant;

public class Column {

	private String columnName;
	private String dataType;
	private int dataLength;
	
	public Column(){
		
	}
	public Column(String columnName, String dataType, int dataLength){
		this.columnName = columnName;
		this.dataType = dataType;
		this.dataLength = dataLength;
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
	public int getDataLength() {
		return dataLength;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}
	public String toString(){
		if (ColumnConstant.DATE.equals(dataType)){
			return columnName + "	" + dataType;
		}
		return columnName + "	" + dataType + "(" + dataLength + ")";
	}
}
