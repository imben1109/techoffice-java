package com.ittechoffice.example.tomcatjsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ittechoffice.example.tomcatjsf.model.User;

@ManagedBean
@SessionScoped
public class UserController {
	private List<User> userList;
	
	public UserController(){
		userList = new ArrayList<User>();
		User user1 = new User("User1", "User1 First Name" , "User1 Last Name", 1);
		userList.add(user1);
		User user2 = new User("User2", "User2 First Name" , "User2 Last Name", 1);
		userList.add(user2);
	}
	
	public List<User> getUserList(){
		return userList;
	}
}
