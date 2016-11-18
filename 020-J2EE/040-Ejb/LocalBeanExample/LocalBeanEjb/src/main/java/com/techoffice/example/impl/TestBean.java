package com.techoffice.example.impl;

import javax.ejb.Stateless;

import com.techoffice.example.intf.Test;

@Stateless
public class TestBean implements Test{

	@Override
	public String sayHi() {
		System.out.println("Hi");
		return "Hi";
	}

}
