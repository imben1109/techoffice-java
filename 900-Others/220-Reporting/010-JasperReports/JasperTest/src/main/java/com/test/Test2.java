package com.test;

import com.test.model.TestModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

    private static List<TestModel> generateTestModelList(){
        List<TestModel> testModels = new ArrayList<TestModel>();

        TestModel testModel1 = new TestModel();
        testModel1.setName("Testing Name 1");
        testModel1.setAddress("Testing Address 1");
        testModels.add(testModel1);

        TestModel testModel2 = new TestModel();
        testModel2.setName("Testing Name 2");
        testModel2.setAddress("Testing Address 2");
        testModels.add(testModel2);

        TestModel testModel3 = new TestModel();
        testModel3.setName("Testing Name 3");
        testModel3.setAddress("Testing Address 3");
        testModels.add(testModel3);

        return testModels;
    }

    public static void main(String[] args) throws Exception {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("test2.jasper");

        List<TestModel> testModels = generateTestModelList();
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(testModels);

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ItemDataSource", jrBeanCollectionDataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, new JREmptyDataSource());
        File file = new File("test2.pdf");
        JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());

    }

}
