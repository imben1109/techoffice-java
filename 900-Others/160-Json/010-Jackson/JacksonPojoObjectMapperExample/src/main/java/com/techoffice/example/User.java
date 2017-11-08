package com.techoffice.example;

import java.util.Date;

public class User {
	private String userid;
	private String name;
	private Date dob;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob(){
		return dob;
	}
	public void setDob(Date dob){
		this.dob = dob;
	}
	
}
