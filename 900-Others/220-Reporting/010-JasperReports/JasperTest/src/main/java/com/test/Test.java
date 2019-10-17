package com.test;


import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("test.jasper");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("PARAMTER1", "Tesing");
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, new JREmptyDataSource());
        File file = new File("test.pdf");
        JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());

    }

}
