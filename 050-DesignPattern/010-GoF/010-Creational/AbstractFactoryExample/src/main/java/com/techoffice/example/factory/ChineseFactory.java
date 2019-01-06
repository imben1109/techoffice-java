package com.techoffice.example.factory;

import com.techoffice.example.factory.intf.Factory;
import com.techoffice.example.model.Chinese;
import com.techoffice.example.model.Person;

public class ChineseFactory implements Factory{

	public Person createPerson() {
		Chinese chinese = new Chinese();
		chinese.setName("created by Chinese Factory");
		return chinese;
	}

}
