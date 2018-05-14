package com.techoffice.oracle.dao;

import java.util.List;

import com.techoffice.oracle.model.AllArgument;
import com.techoffice.oracle.util.OracleDaoUtil;

public class AllArgumentDao {

	private static AllArgumentDao instance = new AllArgumentDao();
	
	private AllArgumentDao(){}
	
	public static AllArgumentDao getInstance(){
		return instance;
	}
	
	public List<AllArgument> getPackageProcedureArgumentList(String packageName, String procedureName) {
		return OracleDaoUtil.list(AllArgument.class, this.getClass(),
				"SELECT * FROM ALL_ARGUMENTS WHERE OBJECT_NAME = '"+ procedureName + "' AND PACKAGE_NAME = '" + packageName + "'");
	}

}
