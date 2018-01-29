package com.techoffice;

import java.util.ArrayList;
import java.util.List;

import com.techoffice.model.User;

public class ApplHelper {

	private ApplHelper(){}
	
	public static List<User> getUserList(){
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setName("Testing User 1");
		list.add(user1);
		User user2 = new User();
		user2.setName("Testing User 2");
		list.add(user2);
		User user3 = new User();
		user3.setName("Testing User 3");
		list.add(user3);
		return list;
	}
}
