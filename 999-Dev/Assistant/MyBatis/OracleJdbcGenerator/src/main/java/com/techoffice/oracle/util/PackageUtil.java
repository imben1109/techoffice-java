package com.techoffice.oracle.util;

import com.techoffice.oracle.constant.PackageConstant;

public class PackageUtil {
	public static String getPackageName(String tableName){
		return PackageConstant.PACKAGE_PREFIX + "_" + tableName;
	}
	
	public static String getSearchProc(String tableName){
		return PackageConstant.SEARCH_PREFIX + "_" + tableName;
	}
	
	public static String getInsertProc(String tableName){
		return PackageConstant.INSERT_PREFIX + "_" + tableName;
	}
	
	public static String getUpdateProc(String tableName){
		return PackageConstant.UPDATE_PREFIX + "_" + tableName;
	}
	
	public static String getDeleteProc(String tableName){
		return PackageConstant.DELETE_PREFIX + "_" + tableName;
	}
}
