package com.techoffice.example;

import fr.xebia.extras.selma.Selma;

public class Appl {
	public static void main(String[] args){
		Modelabc model1 = new Modelabc();
		model1.setName("testing");
		SelmaMapper mapper = Selma.builder(SelmaMapper.class).build();
		Modeldef model2 = mapper.asModel2(model1);
		System.out.println(model2.getName());
	}
}
