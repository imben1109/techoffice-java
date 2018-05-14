package com.techoffice.database.dao.model;

import java.util.List;

public class Key {

	private String keyName;
	private List<Field> fieldList;
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public List<Field> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}

}
