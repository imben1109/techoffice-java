package com.ittechoffice.example.tomcatjsf.model;

public class User {
	private String userName;
	private String firstName;
	private String lastName;
	private int age;
	
	public User(String username, String firstName, String lastName, int age){
		this.userName = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
