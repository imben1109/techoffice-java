package com.techoffice.adapter;

import com.techoffice.model.SelmaModel;
import com.techoffice.model.TestModel;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

@Mapper(
        withIgnoreMissing  = IgnoreMissing.ALL
)
public interface SelmaModelMapper {

    public SelmaModel asSelmaModel(TestModel testModel);

}
