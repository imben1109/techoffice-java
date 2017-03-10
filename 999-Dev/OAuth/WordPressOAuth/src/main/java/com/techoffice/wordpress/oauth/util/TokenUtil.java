package com.techoffice.wordpress.oauth.util;

import com.techoffice.wordpress.config.OAuthConfig;
import com.techoffice.wordpress.oauth.OAuthFlow;
import com.techoffice.wordpress.oauth.OAuthInfo;

public class TokenUtil {
	public static final String AUTHORIZE_URL = "https://public-api.wordpress.com/oauth2/authorize?response_type=code&scope=global";
	public static final String TOKEN_URL = "https://public-api.wordpress.com/oauth2/token";
	public static final String API_VALIDATE_TOKEN_URL = "https://public-api.wordpress.com/oauth2/token-info";
	
	public static String getToken(){
		OAuthInfo oAuthInfo = new OAuthInfo(AUTHORIZE_URL, TOKEN_URL, OAuthConfig.getClientId(), OAuthConfig.getClientSecret(), OAuthConfig.getApplHost(), API_VALIDATE_TOKEN_URL);
		OAuthFlow oAuthFlow = new OAuthFlow(oAuthInfo);
		String token = "";
		try {
			token = oAuthFlow.requestAccessToken();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}

}
