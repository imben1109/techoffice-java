package com.ittechoffice.example;

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
			session.insert("Table1.insert", table1);
			session.commit();
			// QUERY DATA
			List<Table1> list = session.selectList("Table1.select", Table1.class);
			for (Table1 row: list){
				System.out.println(row.getCol1() + " " + row.getCol2());
			}
		} finally {
		  session.close();
		}

	}
}
