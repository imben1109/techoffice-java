package com.techoffice.h2.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.techoffice.database.convertor.AnnotatedFieldConvertor;
import com.techoffice.database.convertor.EntityConvertor;
import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.database.model.Field;
import com.techoffice.database.model.Key;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.h2.config.H2Config;
import com.techoffice.h2.model.Columns;
import com.techoffice.h2.model.Constraints;

public class H2EntityDao implements EntityDao{

	static {
		H2EntityDao h2EntityDao = new H2EntityDao();
		EntityDaoRegistry.add(H2EntityDao.class, h2EntityDao);
	}
	
	private H2EntityDao(){}
	
	@Override
	public List<Field> getFieldList(String tableName) {
		List<Columns> columnsList = ColumnsDao.getInstance().getColumnsList(tableName);
		if (columnsList.size() ==0 ){
			throw new RuntimeException("Cannot find any Column for " + tableName);
		}
		List<Field> fieldList = AnnotatedFieldConvertor.convert(H2Config.class, columnsList);
		return fieldList;
	}

	@Override
	public Entity getEntity(String tableName) {
		Entity entity = new Entity();
		entity.setTableName(tableName);
		
		// field list
		List<Field> fieldList = getFieldList(tableName);
		entity.setFieldList(fieldList);
		
		// key
		Key key = getKey(tableName);
		entity.setPrimaryKey(key);
		
		// Java Class Name
		entity = EntityConvertor.convert(entity);
		return entity;
	}

	@Override
	public Key getKey(String tableName) {
		Key key = new Key();
		Constraints primaryKeyConstraints = ConstraintsDao.getInstance().getPrimaryKeyConstraints(tableName);
		String collumnListStr = primaryKeyConstraints.getColumnList();
		List<String> collumnList = Arrays.asList(collumnListStr.split(","));
		List<Field> fieldList = getFieldList(tableName);
		List<Field> keyFieldList = new ArrayList<Field>();
		for (Field field: fieldList){
			if (collumnList.contains(field.getColumnName())){
				keyFieldList.add(field);
			}
		}
		key.setFieldList(keyFieldList);
		return key;
	}

}
