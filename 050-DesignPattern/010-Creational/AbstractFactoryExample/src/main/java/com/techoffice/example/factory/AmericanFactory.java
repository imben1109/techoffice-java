package com.techoffice.example.factory;

import com.techoffice.example.factory.intf.Factory;
import com.techoffice.example.model.American;
import com.techoffice.example.model.Person;

public class AmericanFactory implements Factory{

	public Person createPerson() {
		American american = new American();
		american.setName("created by American Factory");
		return american;
	}

}
