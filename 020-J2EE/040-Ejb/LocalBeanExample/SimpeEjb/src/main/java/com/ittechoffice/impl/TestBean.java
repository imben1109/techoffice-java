package com.ittechoffice.impl;

import javax.ejb.Stateless;

import com.ittechoffice.intf.Test;

@Stateless
public class TestBean implements Test{

	@Override
	public String sayHi() {
		System.out.println("Hi");
		return "Hi";
	}

}
