package com.techoffice.oracle.dao;

import java.util.List;

import com.techoffice.oracle.model.AllArgument;
import com.techoffice.oracle.util.DaoUtil;

public class AllArgumentDao {

	private static AllArgumentDao instance = new AllArgumentDao();
	
	private AllArgumentDao(){}
	
	public static AllArgumentDao getInstance(){
		return instance;
	}
	
	public List<AllArgument> getPackageProcedureArgumentList(String packageName, String procedureName) {
		return DaoUtil.list(AllArgument.class, "SELECT * FROM ALL_ARGUMENTS WHERE OBJECT_NAME = '"+ procedureName + "' AND PACKAGE_NAME = '" + packageName + "'");
	}

}
