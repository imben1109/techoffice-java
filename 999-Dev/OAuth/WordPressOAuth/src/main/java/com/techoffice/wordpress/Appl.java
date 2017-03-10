package com.techoffice.wordpress;

import java.util.List;
import java.util.Map;

import com.techoffice.wordpress.api.ApiClient;

/**
 * This is Wordpress.com OAuth Example
 * 
 * @author Ben_c
 *
 */
public class Appl {	
	public static void main(String[] args) throws Exception{
		List<Map<String, Object>> sites = ApiClient.getSites();
		for (Map<String, Object> site : sites){
			System.out.println(site.get("ID"));
		}
	}
	
}
