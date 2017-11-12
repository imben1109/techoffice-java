package com.techoffice.csrf;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techoffice.util.RequestUtil;

public final class CookieCsrfTokenRepository {

	private static final String DEFAULT_CSRF_COOKIE_NAME = "XSRF-TOKEN";

	private CookieCsrfTokenRepository(){}
		
	public static String createNewToken(){
		return UUID.randomUUID().toString();
	}
	
	public static void saveToken(String token, HttpServletRequest request, HttpServletResponse response){
		Cookie cookie = new Cookie(DEFAULT_CSRF_COOKIE_NAME, token);
		cookie.setSecure(request.isSecure());
		cookie.setHttpOnly(false);
		response.addCookie(cookie);
	}

	public static String loadToken(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = RequestUtil.getCookie(request.getCookies(), DEFAULT_CSRF_COOKIE_NAME);
		String token = cookie.getValue();
		if (token == null || token.equals("")){
			token = createNewToken();
			saveToken(token, request, response);
		}
		return token;
	}
}
