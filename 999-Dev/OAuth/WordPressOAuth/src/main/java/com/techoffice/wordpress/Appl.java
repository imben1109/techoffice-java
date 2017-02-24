package com.techoffice.wordpress;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.wordpress.oauth.AccessTokenRequest;
import com.techoffice.wordpress.oauth.ApiClient;
import com.techoffice.wordpress.oauth.OAuthInfo;
import com.techoffice.wordpress.oauth.OAuthFlow;

/**
 * This is GitHub OAuth Example
 * @author Ben_c
 *
 */
public class Appl {
	
	public static String AUTHORIZE_URL = "https://public-api.wordpress.com/oauth2/authorize?response_type=code";
	public static String TOKEN_URL = "https://public-api.wordpress.com/oauth2/token";
	
	public static String CLIENT_ID = "50479";
	public static String CLIENT_SECRET = "urXsWEjCefIH7LWo0wLKeqnuvilIrJa2CN8VZasw93cimtSyQoNq2vLTBh39hm0I";
	
	public static String APPL_URL = "http://localhost:8080";
	
	public static String API_USER_INFO_URL = "https://public-api.wordpress.com/rest/v1/me/";
	
	public static void main(String[] args) throws Exception{
		OAuthInfo oAuthInfo = new OAuthInfo(AUTHORIZE_URL, TOKEN_URL, CLIENT_ID, CLIENT_SECRET, APPL_URL);
		OAuthFlow OAuthFlow = new OAuthFlow(oAuthInfo);
		String token = OAuthFlow.requestAccessToken();
		ApiClient.getApiReturn(API_USER_INFO_URL, token);
	}
	
}
