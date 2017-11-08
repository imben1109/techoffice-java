package com.techoffice.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@Autowired
	private JdbcDaoImpl userDetailsService;
	
	@Autowired
	private DaoAuthenticationProvider DaoAuthenticationProvider;
	
	@RequestMapping(value="/userQuery")
	@ResponseBody
	public String test(){
		String userQuery = userDetailsService.getUsersByUsernameQuery();
		
		List<Map<String, Object>> userList = userDetailsService.getJdbcTemplate().queryForList("select username, password, enabled from users");		
		for (Map<String, Object> user: userList){
			System.out.println(user.get("username"));
			System.out.println(user.get("password"));
			System.out.println(user.get("enabled"));
		}
		List<Map<String, Object>> authorityList = userDetailsService.getJdbcTemplate().queryForList("select username, authority from authorities");
		for (Map<String, Object> authority: authorityList){
			System.out.println(authority.get("username"));
			System.out.println(authority.get("authority"));
		}
	    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("user", "password");
	    try{
	    	Authentication authentication = DaoAuthenticationProvider.authenticate(auth);
			System.out.println(authentication.isAuthenticated());
	    }catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	    
//		UserDetails user = userDetailsService.loadUserByUsername("user");
		return userQuery;
	}
}
