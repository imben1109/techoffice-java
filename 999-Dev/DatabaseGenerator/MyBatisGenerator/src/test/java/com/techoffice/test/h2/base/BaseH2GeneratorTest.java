package com.techoffice.test.h2.base;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.h2.dao.H2EntityDao;

public abstract class BaseH2GeneratorTest {

	public EntityDao getEntityDao(){
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(H2EntityDao.class);
		return entityDao;
	}
	
}
