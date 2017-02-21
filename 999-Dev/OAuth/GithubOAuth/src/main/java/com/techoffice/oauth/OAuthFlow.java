package com.techoffice.oauth;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

/**
 * OAuth for Github
 * Reference: https://developer.github.com/v3/oauth/
 * 
 * @author Ben_c
 *
 */
public class OAuthFlow {
	
	private OAuth oauth;
	
	public OAuthFlow(OAuth oauth){
		this.oauth = oauth;
	}
	
	public String requestAccess(){
		try {
			LocalServer.start();
			Desktop desktop = Desktop.getDesktop();
			URI AuthorizeUri = AuthorizeUriBuilder.build(oauth.getAuthorizeUrl(), oauth.getClientId(), oauth.getRedirectUrl());
			desktop.browse(AuthorizeUri);
			LocalServer.waitFor();
			String code = LocalServer.getCode();
			AccessTokenBuilder.setCode(code);
			return LocalServer.getCode();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
