package com.techoffice.example;

import org.springframework.stereotype.Repository;

import com.techoffice.dao.base.BaseDao;

@Repository
public class Dao extends BaseDao<Table1> {

	@Override
	protected Class<Table1> getEntityClass() {
		return Table1.class;
	}
	
}
