package com.techoffice.dao;

import java.util.List;

import com.techoffice.criteria.TestCriteria;
import com.techoffice.entity.Test;
import com.techoffice.key.TestKey;

public interface TestDao {

	public List<Test> search(TestCriteria testCriteria);
	public Test find(TestKey testKey);
	public int insert(Test test);
	public int update(Test test);
	public int delete(TestKey testKey);
	
}