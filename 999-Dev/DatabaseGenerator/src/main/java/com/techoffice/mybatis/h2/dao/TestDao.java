package com.techoffice.mybatis.h2.dao;

import java.util.List;

import com.techoffice.mybatis.h2.util.DaoUtil;



public class TestDao {
	
	public static List<Object> getPackageProcedureArgumentList() {
		return DaoUtil.list(Object.class, "SELECT * FROM TEMP_TABLE");
	}
	
	public static void main(String[] args){
		getPackageProcedureArgumentList().size();
	}
	
}
