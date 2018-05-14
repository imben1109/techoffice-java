package com.techoffice.h2.dao;

import java.util.List;

import com.techoffice.h2.model.Constraints;
import com.techoffice.h2.util.H2DaoUtil;

public class ConstraintsDao {
	
	private static ConstraintsDao instance = new ConstraintsDao();
	
	private ConstraintsDao(){}
	
	
	public static ConstraintsDao getInstance(){
		return instance;
	}
	
	public List<Constraints> getConstraintsList(String tableName){
		return H2DaoUtil.list(Constraints.class, ConstraintsDao.class,
				"SELECT * FROM INFORMATION_SCHEMA.CONSTRAINTS WHERE TABLE_NAME ='"+tableName+"'");
	}

	public Constraints getPrimaryKeyConstraints(String tableName){
		List<Constraints> constraintsList =  H2DaoUtil.list(Constraints.class, ConstraintsDao.class, 
				"SELECT * FROM INFORMATION_SCHEMA.CONSTRAINTS WHERE CONSTRAINT_TYPE = 'PRIMARY KEY' AND TABLE_NAME ='"+tableName+"'");
		if (constraintsList.size() > 0){
			return constraintsList.get(0);	
		}else {
			throw new RuntimeException("cannot find primary key");
		}
		
	}
}
