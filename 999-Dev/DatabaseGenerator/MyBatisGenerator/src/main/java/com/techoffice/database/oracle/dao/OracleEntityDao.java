package com.techoffice.database.oracle.dao;

import java.util.List;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.dao.model.Entity;
import com.techoffice.database.dao.model.Field;
import com.techoffice.database.dao.model.Key;
import com.techoffice.database.dao.registry.EntityDaoRegistry;

public class OracleEntityDao implements EntityDao{

	static {
		OracleEntityDao oracleEntityDao = new OracleEntityDao();
		EntityDaoRegistry.add(OracleEntityDao.class, oracleEntityDao);
	}

	@Override
	public List<Field> getFieldList(String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getEntity(String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key getKey(String tableName) {
		// TODO Auto-generated method stub
		return null;
	}
}
