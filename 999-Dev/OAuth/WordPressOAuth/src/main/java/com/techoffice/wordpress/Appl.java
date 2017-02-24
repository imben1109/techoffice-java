package com.techoffice.wordpress;

import com.techoffice.wordpress.api.ApiClient;
import com.techoffice.wordpress.oauth.OAuthFlow;
import com.techoffice.wordpress.oauth.OAuthInfo;

/**
 * This is GitHub OAuth Example
 * @author Ben_c
 *
 */
public class Appl {
	
	public static final String AUTHORIZE_URL = "https://public-api.wordpress.com/oauth2/authorize?response_type=code";
	public static final String TOKEN_URL = "https://public-api.wordpress.com/oauth2/token";
	
	public static final String CLIENT_ID = "50479";
	public static final String CLIENT_SECRET = "urXsWEjCefIH7LWo0wLKeqnuvilIrJa2CN8VZasw93cimtSyQoNq2vLTBh39hm0I";
	
	public static final String APPL_URL = "http://localhost:8080";
	
	public static final String API_VALIDATE_TOKEN_URL = "https://public-api.wordpress.com/oauth2/token-info";
	public static final String API_USER_INFO_URL = "https://public-api.wordpress.com/rest/v1/me/";
	
	
	public static void main(String[] args) throws Exception{
		OAuthInfo oAuthInfo = new OAuthInfo(AUTHORIZE_URL, TOKEN_URL, CLIENT_ID, CLIENT_SECRET, APPL_URL, API_VALIDATE_TOKEN_URL);
		OAuthFlow oAuthFlow = new OAuthFlow(oAuthInfo);
		String token = oAuthFlow.requestAccessToken();
		System.out.println("Access Token: " + token);
		ApiClient.getApiReturn(API_USER_INFO_URL, token);
	}
	
}
