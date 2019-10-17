package com.test;

import com.test.model.TestModel;
import com.test.model.TestNestedModel;
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

public class Test3 {
    private static List<TestNestedModel> generateTestNestedModelList(int count){
        List<TestNestedModel> testNestedModels = new ArrayList<TestNestedModel>();
        for(int i=0; i<count; i++){
            TestNestedModel testNestedModel1 = new TestNestedModel();
            testNestedModel1.setName("Testing Nested Name 1");
            testNestedModels.add(testNestedModel1);
        }
        return testNestedModels;
    }

    private static List<TestModel> generateTestModelList(){
        List<TestModel> testModels = new ArrayList<TestModel>();

        TestModel testModel1 = new TestModel();
        testModel1.setName("Testing Name 1");
        testModel1.setAddress("Testing Address 1");
        testModels.add(testModel1);
        testModel1.setDataList(generateTestNestedModelList(20));

        TestModel testModel2 = new TestModel();
        testModel2.setName("Testing Name 2");
        testModel2.setAddress("Testing Address 2");
        testModel2.setDataList(generateTestNestedModelList(3));
        testModels.add(testModel2);

        TestModel testModel3 = new TestModel();
        testModel3.setName("Testing Name 3");
        testModel3.setAddress("Testing Address 3");
        testModel3.setDataList(generateTestNestedModelList(16));
        testModels.add(testModel3);

        return testModels;
    }

    public static void main(String[] args) throws Exception {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("test3.jasper");

        List<TestModel> testModels = generateTestModelList();
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(testModels);

        Map<String, Object> parameters = new HashMap<String, Object>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, jrBeanCollectionDataSource);
        File file = new File("test3.pdf");
        JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());

    }

}
