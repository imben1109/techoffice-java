package com.techoffice.service;

import com.techoffice.model.TestModel;

public class TestModelService {

    TestModel getMockTestModel(){
        TestModel testModel = new TestModel();
        testModel.setName("Testing Name");
        testModel.setAge(10);
        testModel.setAddress("Testing Address");
        return testModel;
    }
}
