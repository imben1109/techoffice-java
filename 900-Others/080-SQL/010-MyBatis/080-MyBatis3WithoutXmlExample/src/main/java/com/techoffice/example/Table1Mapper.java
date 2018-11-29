package com.techoffice.example;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface Table1Mapper {

	@Select("SELECT * FROM Table1")
	public List<Table1> select();
	
}
