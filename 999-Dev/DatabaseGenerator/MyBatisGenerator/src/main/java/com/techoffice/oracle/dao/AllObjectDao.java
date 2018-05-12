package com.techoffice.oracle.dao;

import java.util.List;

import com.techoffice.oracle.model.AllObject;
import com.techoffice.oracle.util.OracleDaoUtil;

public class AllObjectDao {

	public List<AllObject> getAllPackageObject() {
		return OracleDaoUtil.list(AllObject.class, "SELECT * FROM ALL_OBJECTS WHERE OBJECT_TYPE = 'PACKAGE'");
	}
	
}
