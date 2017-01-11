package com.techoffice.oauth;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

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
			return LocalServer.getCode();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
