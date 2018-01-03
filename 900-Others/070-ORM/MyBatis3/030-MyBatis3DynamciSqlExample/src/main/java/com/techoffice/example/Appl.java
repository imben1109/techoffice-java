package com.techoffice.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Appl {
	public static void main(String[] args) throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// CREATE TABLE 
			session.update("CreateTable.createTable1");
			// INSERT DATA
			Table1 table1 = new Table1();
			table1.setCol1("Col1");
			table1.setCol2("Col2");
			table1.setCol3(4.50123);
			session.insert("Table1.insert", table1);
			session.commit();
			
			// QUERY DATA
			List<Table1> list = session.selectList("Table1.select");
			for (Table1 row: list){
				System.out.println(row.getCol1() + " " + row.getCol2() + " " + row.getCol3());
			}
			
			//
			Map<String, String> map1 = new HashMap<String, String>();
			map1.put("col1", "col1");
			session.selectList("Table1.selectPrepareStatement", map1);
			
			Map<String, String> map2 = new HashMap<String, String>();
			map1.put("table1", "table1");
			session.selectList("Table1.SelectDynamicSql", map1);

		} finally {
		  session.close();
		}

	}
}
