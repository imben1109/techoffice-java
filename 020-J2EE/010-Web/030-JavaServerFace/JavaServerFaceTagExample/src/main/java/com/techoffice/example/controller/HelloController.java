package com.techoffice.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.techoffice.example.model.User;

@ManagedBean
@SessionScoped
public class HelloController {
	private String name;	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
