package com.techoffice.example;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;

@Mapper(
	    withCustomFields = {
	            @Field({"customer.fullName", "customerFullName"}),
	            @Field({"reference", "ref"})
	        },
	        withIgnoreFields = "id"
)
public interface SelmaMapper {

    Modeldef asModel2(Modelabc model1);

    Modelabc asModel1(Modeldef in, Modelabc out);

}
