package com.techoffice.wordpress.oauth;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import org.apache.commons.lang3.StringUtils;

import com.techoffice.wordpress.oauth.request.AccessTokenRequest;
import com.techoffice.wordpress.oauth.request.ValidateTokenRequest;
import com.techoffice.wordpress.oauth.request.helper.AuthorizeUriBuilder;
import com.techoffice.wordpress.oauth.server.LocalServer;

/**
 * OAuth for WordPress
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
	
	public String requestAccessToken() throws Exception{
		try {
			String token = "";
			token = TokenStore.readStoreFile();
			
			
			boolean validToken = ValidateTokenRequest.validateToken(token, oAuthInfo);
			
			if (StringUtils.isEmpty(token) || !validToken){
				// retrieve authorized code
				String code = requestAuthorizedCode();
				
				// retrieve token 
				token = AccessTokenRequest.getToken(oAuthInfo, code);
				
				// store code into codeStore 
				TokenStore.writeStoreFile(token);
			}
			
			return token;
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	private String requestAuthorizedCode() throws Exception{
		// Start a Local Server for receive code redirect from WordPress Authorize Page.
		LocalServer oAuthLocalServer = new LocalServer();
		oAuthLocalServer.start();
		
		
		// Because it need a browser for user to press and obtain the authorization right.
		Desktop desktop = Desktop.getDesktop();
		URI authorizeUri = AuthorizeUriBuilder.build(oAuthInfo.getAuthorizeUrl(), oAuthInfo.getClientId(), oAuthInfo.getRedirectUrl());
		System.out.println(authorizeUri);
		desktop.browse(authorizeUri);
		
		// Wait for Local Server receiving the code 
		oAuthLocalServer.waitFor();
		String code = oAuthLocalServer.getCode();
		
		return code;
	}
	
}
