package com.techoffice.h2.dao;

import java.util.List;

import com.techoffice.database.convertor.AnnotatedFieldConvertor;
import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.database.model.Field;
import com.techoffice.database.model.Key;
import com.techoffice.h2.model.Columns;

public class H2EntityDao implements EntityDao{

	@Override
	public List<Field> getFieldList(String tableName) {
		List<Columns> columnsList = ColumnsDao.getInstance().getColumnsList(tableName);
		return AnnotatedFieldConvertor.convert(columnsList);
	}

	@Override
	public Entity getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key getKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
