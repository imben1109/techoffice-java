package com.techoffice.example;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Appl {
	public static void main(String[] args) throws JRException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("TITLE", "Testing Title");
//		JasperFillManager.fillReportTo
	      ArrayList<Test> dataList = new ArrayList<Test>();
	      Test t1 = new Test();
	      t1.setField1("Testing");
	      t1.setField2("Testing");
	      Test t2 = new Test();
	      t2.setField1("Testing 2");
	      t2.setField2("Testing 2");
	      dataList.add(t1);
	      dataList.add(t2);
	      File sourcefile = new File("report1.jasper");
	      System.out.println(sourcefile.getAbsolutePath());
	      JRBeanCollectionDataSource beanColDataSource = new 
	    	         JRBeanCollectionDataSource(dataList);
	         String report = JasperFillManager.fillReportToFile( 
	        		 sourcefile.getAbsolutePath(), parameters, beanColDataSource);
	         JasperExportManager.exportReportToPdfFile(report, "test.pdf");

	}
}
