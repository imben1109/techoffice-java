package com.techoffice.database.dao;

import java.util.List;

import com.techoffice.database.model.Entity;
import com.techoffice.database.model.Field;
import com.techoffice.database.model.Key;

public interface EntityDao {
	
	List<Field> getFieldList(String tableName);
	Entity getEntity();
	Key getKey();
	
}
