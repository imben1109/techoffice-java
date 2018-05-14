package com.techoffice.database.dao;

import java.util.List;

import com.techoffice.database.dao.model.Entity;
import com.techoffice.database.dao.model.Field;
import com.techoffice.database.dao.model.Key;

public interface EntityDao {
	
	List<Field> getFieldList(String tableName);
	Entity getEntity(String tableName);
	Key getKey(String tableName);
	
}
