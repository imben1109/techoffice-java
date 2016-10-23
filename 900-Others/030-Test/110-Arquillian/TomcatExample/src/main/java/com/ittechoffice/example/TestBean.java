package com.ittechoffice.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class TestBean {
	
	public void sayHi(){
		System.out.println("Hi");
	}
	
}
