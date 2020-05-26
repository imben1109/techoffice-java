package com.techoffice.service;

import com.techoffice.model.SelmaModel;
import org.junit.Assert;
import org.junit.Test;

public class SelmaModelServiceTest {

    private SelmaModelService selmaModelService = new SelmaModelService();

    @Test
    public void testSelmaModel(){
        SelmaModel selmaModel = selmaModelService.getMockSelmaModel();
        Assert.assertEquals("Testing Name", selmaModel.getName());
        Assert.assertEquals(Integer.valueOf(10), selmaModel.getAge());
        Assert.assertEquals("Testing Address", selmaModel.getAddress());
    }

}
