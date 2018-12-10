package com.techoffice.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
			Table1Dao table1Mapper = session.getMapper(Table1Dao.class);
			List<Table1> list = table1Mapper.select();
			for (Table1 row: list){
				System.out.println(row.getCol1() + " " + row.getCol2() + " " + row.getCol3());
			}
		} finally {
		  session.close();
		}

	}
}
