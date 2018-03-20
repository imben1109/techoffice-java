package com.techoffice.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.techoffice.validator.annoation.Test;

@Test(field1="name", field2="dob")
public class User {
		
	private String name;
	
	private Date dob;
	
	@Valid
	private List<Role> roles;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
