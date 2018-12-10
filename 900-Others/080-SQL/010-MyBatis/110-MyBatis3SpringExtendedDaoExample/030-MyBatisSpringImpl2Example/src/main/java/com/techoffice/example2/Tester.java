package com.techoffice.example2;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.techoffice.example2.entity.Table1;
import com.techoffice.example2.service.impl.Table1ServiceImpl;

@Component
public class Tester {

	@Resource
	private Table1ServiceImpl table1Service;
	
	public void test(){
		List<Table1> table1List = table1Service.select();
		for (Table1 table1: table1List){
			System.out.println(table1.getCol1());
		}
	}
}
