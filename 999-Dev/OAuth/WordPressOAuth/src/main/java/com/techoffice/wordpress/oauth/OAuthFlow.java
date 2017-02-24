package com.techoffice.wordpress.oauth;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

/**
 * OAuth for Github
 * 
 * Reference: https://developer.github.com/v3/oauth/
 * 
 * @author Ben_c
 *
 */
public class OAuthFlow {
	
	private OAuthInfo oAuthInfo;
	
	public OAuthFlow(OAuthInfo oAuthInfo){
		this.oAuthInfo = oAuthInfo;
	}
	
	public String requestAccessToken(){
		try {
			// Start a Local Server for receive code redirect from WordPress Authorize Page.
			LocalServer.start();
			
			// Because it need a browser for user to press and obtain the authorization right.
			Desktop desktop = Desktop.getDesktop();
			URI authorizeUri = AuthorizeUriBuilder.build(oAuthInfo.getAuthorizeUrl(), oAuthInfo.getClientId(), oAuthInfo.getRedirectUrl());
			System.out.println(authorizeUri);
			desktop.browse(authorizeUri);
			
			// Wait for Local Server receiving the code 
			LocalServer.waitFor();
			String code = LocalServer.getCode();
			
			String token = AccessTokenRequest.getToken(code);
			
			return token;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
