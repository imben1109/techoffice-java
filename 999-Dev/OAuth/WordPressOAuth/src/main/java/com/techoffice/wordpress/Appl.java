package com.techoffice.wordpress;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.wordpress.oauth.AccessTokenBuilder;
import com.techoffice.wordpress.oauth.ApiClient;
import com.techoffice.wordpress.oauth.OAuth;
import com.techoffice.wordpress.oauth.OAuthFlow;

/**
 * This is GitHub OAuth Example
 * @author Ben_c
 *
 */
public class Appl {
	
	public static String TOKEN_URL = "https://public-api.wordpress.com/oauth2/token";
	public static String AUTHORIZE_URL = "https://public-api.wordpress.com/oauth2/authorize?response_type=code";
	public static String CLIENT_ID = "50479";
	public static String CLIENT_SECRET = "urXsWEjCefIH7LWo0wLKeqnuvilIrJa2CN8VZasw93cimtSyQoNq2vLTBh39hm0I";
	public static String APPL_URL = "http://localhost:8080";
	
	public static String API_USER_INFO_URL = "https://public-api.wordpress.com/rest/v1/me/";
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		OAuth oauth = new OAuth(AUTHORIZE_URL, TOKEN_URL, CLIENT_ID, CLIENT_SECRET);
		OAuthFlow OAuthFlow = new OAuthFlow(oauth);
		OAuthFlow.requestAccess();
		AccessTokenBuilder.getToken();
		ApiClient.getApiReturn(API_USER_INFO_URL);
	}
	
}
