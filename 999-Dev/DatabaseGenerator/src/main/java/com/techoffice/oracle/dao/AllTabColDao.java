package com.techoffice.oracle.dao;

import java.util.List;

import com.techoffice.oracle.model.AllTabCol;
import com.techoffice.oracle.util.DaoUtil;

public class AllTabColDao {

	public static List<AllTabCol> getTableColumnList(String tableName){
		return DaoUtil.list(AllTabCol.class, "SELECT * FROM ALL_TAB_COLS WHERE TABLE_NAME = '"+tableName+"'");
	}
	
	public static void main(String[] args){
		List<AllTabCol> allTabColList = getTableColumnList("BM_SETL_ACTN_XREF_DETL");
		for (AllTabCol allTabCol: allTabColList){
			System.out.println(allTabCol.getColumnName()+ ": "+ allTabCol.getDataType() + " " + allTabCol.getDataPrecision() + " " + allTabCol.getDataScale());
		}
	}
	
}
