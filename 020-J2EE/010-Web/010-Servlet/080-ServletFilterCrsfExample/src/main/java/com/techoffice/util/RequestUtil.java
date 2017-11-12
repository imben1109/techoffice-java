package com.techoffice.util;

import javax.servlet.http.Cookie;

public class RequestUtil {

	private RequestUtil(){}
	
	public static Cookie getCookie(Cookie[] cookies, String name){
		if (cookies != null){
			for (int i=0; i<cookies.length; i++){
				Cookie cookie = cookies[i];
				if (cookie.getName().equals(name)){
					return cookie;
				}
			}
		}
		return null;
	}
}
