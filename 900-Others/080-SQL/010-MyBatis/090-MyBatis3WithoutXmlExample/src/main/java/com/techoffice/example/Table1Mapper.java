package com.techoffice.example;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

public interface Table1Mapper {

	@SelectProvider(type=TableSqlProvider.class, method="getSelect")
	public List<Table1> select();
	
}
