package com.techoffice.example;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Table1Dao {

	@Autowired
	private SqlSession sqlSession;

	@Transactional
	public int insert(Table1 table1){
		return sqlSession.insert("Table1.insert", table1);
	}
	
	@Transactional
	public List<Table1> select(){
		return sqlSession.selectList("Table1.select");
	}
	
	public void createTable1(){
		sqlSession.selectOne("Table1.createTable1");
	}
}
