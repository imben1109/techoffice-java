package com.techoffice.example;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;

import com.techoffice.example.model.User;

public class BeanMapExample {
	
	public static void main(String[] args){
		User user = new User();
		user.setName("Test Name");
		user.setAge(20);
		user.setDob(new Date());
		user.setIncome(100.0);
		user.setDeposit(new BigDecimal(1000));
		Map<Object, Object> map = new BeanMap(user);
		System.out.println(map);
		System.out.println(map.get("name") + "   " + map.get("name").getClass().toString());
		System.out.println(map.get("age") + "   "+ map.get("age").getClass().toString());
		System.out.println(map.get("dob") + "   " + map.get("dob").getClass().toString());
		System.out.println(map.get("income") + "   " + map.get("income").getClass().toString());
		System.out.println(map.get("deposit") + "   " + map.get("deposit").getClass().toString());

	}

}
