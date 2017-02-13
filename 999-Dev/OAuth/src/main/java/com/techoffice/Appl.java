package com.techoffice;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.oauth.AccessTokenBuilder;
import com.techoffice.oauth.ApiClient;
import com.techoffice.oauth.OAuth;
import com.techoffice.oauth.OAuthFlow;

public class Appl {
	
	public static String TOKEN_URL = "https://github.com/login/oauth/access_token";
	public static String AUTHORIZE_URL = "https://github.com/login/oauth/authorize";
	public static String CLIENT_ID = "480856be9f03afee4633";
	public static String CLIENT_SECRET = "7657c6bbfb35e03661fe176c716197cb579db51a";
	
	public static String API_USER_INFO_URL = "https://api.github.com/user";
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		OAuth oauth = new OAuth(AUTHORIZE_URL, TOKEN_URL, CLIENT_ID, CLIENT_SECRET);
		OAuthFlow OAuthFlow = new OAuthFlow(oauth);
		OAuthFlow.requestAccess();
		AccessTokenBuilder.getToken();
		ApiClient.getApiReturn(API_USER_INFO_URL);
	}
	
}
