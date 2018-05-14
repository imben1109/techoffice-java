package com.techoffice.database.h2.dao;

import java.util.List;

import com.techoffice.database.h2.model.Constraints;
import com.techoffice.database.h2.util.H2DaoUtil;

public class ConstraintsDao {
	
	private static ConstraintsDao instance = new ConstraintsDao();
	
	private ConstraintsDao(){}
	
	
	public static ConstraintsDao getInstance(){
		return instance;
	}
	
	public List<Constraints> getConstraintsList(String tableName){
		return H2DaoUtil.list(Constraints.class, this.getClass(),
				"SELECT * FROM INFORMATION_SCHEMA.CONSTRAINTS WHERE TABLE_NAME ='"+tableName+"'");
	}

	public Constraints getPrimaryKeyConstraints(String tableName){
		List<Constraints> constraintsList =  H2DaoUtil.list(Constraints.class, this.getClass(), 
				"SELECT * FROM INFORMATION_SCHEMA.CONSTRAINTS WHERE CONSTRAINT_TYPE = 'PRIMARY KEY' AND TABLE_NAME ='"+tableName+"'");
		if (constraintsList.size() == 0){
			throw new RuntimeException("Cannot find Primary Key for " + tableName);
		}
		return constraintsList.get(0);
	}
}
