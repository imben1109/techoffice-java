package com.ittechoffice.example.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * HellpBean is an example of Managed Bean. 
 * Managed Bean is Java Bean Class registered in JSF. Therefore, Managed Bean is manged in JSF framework. 
 * It can be accessed by JSF Page. 
 * 
 * @author Ben_c
 *
 */
@ManagedBean
public class HelloBean {
	private String hello = "Hello123!!";
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getHello(){
		return hello;
	}
	
	
}
