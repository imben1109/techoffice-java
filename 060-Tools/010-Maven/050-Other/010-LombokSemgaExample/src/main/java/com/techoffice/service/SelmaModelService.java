package com.techoffice.service;

import com.techoffice.adapter.SelmaModelMapper;
import com.techoffice.model.SelmaModel;
import com.techoffice.model.TestModel;
import fr.xebia.extras.selma.Selma;

public class SelmaModelService {

    SelmaModelMapper selmaModelMapper = Selma.getMapper(SelmaModelMapper.class);
    TestModelService testModelService = new TestModelService();

    public SelmaModel getMockSelmaModel(){
        TestModel testModel = testModelService.getMockTestModel();
        SelmaModel selmaModel = selmaModelMapper.asSelmaModel(testModel);
        return selmaModel;
    }

}
