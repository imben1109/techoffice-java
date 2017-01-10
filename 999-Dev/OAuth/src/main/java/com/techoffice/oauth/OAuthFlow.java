package com.techoffice.oauth;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class OAuthFlow {
	
	private OAuth oauth;
	
	public OAuthFlow(OAuth oauth){
		this.oauth = oauth;
	}
	
	public void requestAccess(){
		try {
			LocalServer localServer = new LocalServer();
			localServer.start();
			Desktop desktop = Desktop.getDesktop();
			URI AuthorizeUri = AuthorizeUriBuilder.build(oauth.getAuthorizeUrl(), oauth.getClientId(), oauth.getRedirectUrl());
			desktop.browse(AuthorizeUri);
			localServer.waitFor();
			System.out.println("DONE");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
