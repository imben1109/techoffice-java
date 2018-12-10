package com.techoffice.example;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BaseTable1Dao<T extends BaseTable1> {

	@Select("SELECT * FROM Table1")
	public List<T> select();
	
}
