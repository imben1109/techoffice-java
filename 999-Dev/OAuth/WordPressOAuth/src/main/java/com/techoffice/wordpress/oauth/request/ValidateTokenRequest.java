package com.techoffice.wordpress.oauth.request;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.techoffice.htmlunit.WebClientFactory;
import com.techoffice.wordpress.oauth.OAuthInfo;

public class ValidateTokenRequest {
	
	public static boolean validateToken(String token, OAuthInfo oAuthInfo) throws MalformedURLException, IOException{
	    WebClient webClient = WebClientFactory.create();
	    try{
	    	final UnexpectedPage page =  webClient.getPage(oAuthInfo.getTokenValidateUrl() + "?client_id=" + oAuthInfo.getClientId() + "&token=" + URLEncoder.encode(token, "UTF-8"));
	    	String response = page.getWebResponse().getContentAsString();
		    System.out.println(response);
		    return true;
	    }catch(FailingHttpStatusCodeException e){
	    	System.out.println(e.getStatusCode());
	    }
	    
		return false;
	}
}
