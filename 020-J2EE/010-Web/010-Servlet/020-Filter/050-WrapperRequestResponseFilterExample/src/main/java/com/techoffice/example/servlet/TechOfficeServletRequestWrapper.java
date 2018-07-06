package com.techoffice.example.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TechOfficeServletRequestWrapper extends HttpServletRequestWrapper{

	public TechOfficeServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
    public Object getAttribute(String name){
    	System.out.println("Customized Request");
    	return this.getRequest().getAttribute(name);
    }

}
