package com.techoffice.service.impl.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techoffice.dao.base.BaseTable1Dao;
import com.techoffice.entity.base.BaseTable1;
import com.techoffice.service.Table1Service;

public class BaseTable1SericeImpl <T extends BaseTable1> implements Table1Service<T>{

	@Autowired
	private BaseTable1Dao<T> baseTableDao;
	
	public List<T> select(){
		return baseTableDao.select();
	}

}
