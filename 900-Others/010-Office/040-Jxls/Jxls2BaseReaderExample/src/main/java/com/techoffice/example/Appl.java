package com.techoffice.example;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.xml.sax.SAXException;

import com.techoffice.reader.base.BaseExcelReader;

public class Appl extends BaseExcelReader<List<Employee>>{

	@Override
	public InputStream getConfig() {
		return new BufferedInputStream(Appl.class.getResourceAsStream("departmentdata.xml"));
	}

	@Override
	public List<Employee> getBean() {
	    List<Employee> employees = new ArrayList<Employee>();
		return employees;
	}
	
	public static void main(String[] args) throws IOException, SAXException, InvalidFormatException {
	    Appl appl = new Appl();
	    List<Employee> employees = appl.read(new File("departmentdata.xls"));
	    System.out.println(employees.size());
	}
}
