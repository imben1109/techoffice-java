package com.techoffice.data.generator.model;

import java.util.List;

import com.techoffice.database.model.Entity;

public class EntityData {

	private Entity entity;
	private List<FieldData> fieldDataList;
	
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public List<FieldData> getFieldDataList() {
		return fieldDataList;
	}
	public void setFieldDataList(List<FieldData> fieldDataList) {
		this.fieldDataList = fieldDataList;
	}
	
	
}
