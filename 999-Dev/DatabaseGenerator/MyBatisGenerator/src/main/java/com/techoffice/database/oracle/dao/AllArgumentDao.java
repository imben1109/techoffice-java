package com.techoffice.database.oracle.dao;

import java.util.List;

import com.techoffice.database.dao.oracle.util.OracleDaoUtil;
import com.techoffice.database.oracle.model.AllArgument;

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
