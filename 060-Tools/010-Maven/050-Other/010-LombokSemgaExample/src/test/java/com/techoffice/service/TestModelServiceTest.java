package com.techoffice.service;

import com.techoffice.model.TestModel;
import org.junit.Assert;
import org.junit.Test;

public class TestModelServiceTest {

    TestModelService testModelService = new TestModelService();

    @Test
    public void testGetterSetter(){
        TestModel testModel = testModelService.getMockTestModel();
        Assert.assertEquals("Testing Name", testModel.getName());
        Assert.assertEquals(Integer.valueOf(10), testModel.getAge());
        Assert.assertEquals("Testing Address", testModel.getAddress());
    }

}
