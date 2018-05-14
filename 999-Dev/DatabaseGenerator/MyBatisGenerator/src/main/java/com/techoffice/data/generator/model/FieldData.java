package com.techoffice.data.generator.model;

import java.util.Date;

import com.techoffice.data.generator.config.EntityDataDateConfig;
import com.techoffice.database.model.Field;

public class FieldData{

	private Field field;
	private Object value;
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString(){
		if (this.value instanceof String){
			return "'" + this.value.toString() + "'";
		}
		if (this.value instanceof Date){
			Date date = (Date) value;
			String str = EntityDataDateConfig.getJdbcToDateString(date);
			return str;
		}
		return this.value.toString();
	}
	
	
}
