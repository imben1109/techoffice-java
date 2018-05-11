package com.techoffice.oracle.dao;

import java.util.List;

import com.techoffice.oracle.model.AllObject;
import com.techoffice.oracle.util.DaoUtil;

public class AllObjectDao {

	public static List<AllObject> getAllPackageObject() {
		return DaoUtil.list(AllObject.class, "SELECT * FROM ALL_OBJECTS WHERE OBJECT_TYPE = 'PACKAGE'");
	}
	
	public static void main(String[] args) {
		List<AllObject> allObjectList = getAllPackageObject();
		for (AllObject allObject: allObjectList ){
			System.out.println(allObject.getObjectName());
		}
	}
	
}
