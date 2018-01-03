package com.techoffice.example;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

public class Appl {
	public static void main(String[] args) throws IOException, SAXException, InvalidFormatException {
	    InputStream inputXML = new BufferedInputStream(Appl.class.getResourceAsStream("departmentdata.xml"));
	    XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );
	    InputStream inputXLS = new BufferedInputStream(Appl.class.getResourceAsStream("departmentdata.xls"));
	    List<Employee> employees = new ArrayList<Employee>();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("employees", employees);
	    mainReader.read(inputXLS, map);
	    System.out.println(employees.size());
	}
}
