package com.techoffice.h2.dao;

import java.util.List;

import com.techoffice.h2.model.Constraints;
import com.techoffice.h2.util.DaoUtil;

public class ConstraintsDao {

	public List<Constraints> getConstraintsList(String tableName){
		return DaoUtil.list(Constraints.class, "SELECT * FROM INFORMATION_SCHEMA.CONSTRAINTS WHERE TABLE_NAME ='"+tableName+"'");
	}

	public Constraints getPrimaryKeyConstraints(String tableName){
		List<Constraints> constraintsList =  DaoUtil.list(Constraints.class, "SELECT * FROM INFORMATION_SCHEMA.CONSTRAINTS WHERE CONSTRAINT_TYPE = 'PRIMARY KEY' AND TABLE_NAME ='"+tableName+"'");
		return constraintsList.get(0);
	}
}
