package com.techoffice.wordpress.oauth.request.helper;

import java.net.URI;
import java.net.URISyntaxException;

public class AuthorizeUriBuilder {
	public static final String CLIENT_ID = "client_id";
	public static final String REDIRECT_URI = "redirect_uri";
	
	public static URI build(String authorizeUrl, String clientId, String redirectUrl){
		String uriStr = "";
		if (!isParamAlreadySet(authorizeUrl)){
			uriStr = authorizeUrl + "?" + CLIENT_ID + "=" + clientId + "&" + REDIRECT_URI + "=" + redirectUrl;
		}else{
			uriStr = authorizeUrl + "&" + CLIENT_ID + "=" + clientId + "&" + REDIRECT_URI + "=" + redirectUrl;
		}
		URI uri = null;
		try {
			uri = new URI(uriStr);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return uri;
	}
	
	private static boolean isParamAlreadySet(String authorizeUrl){
		if (authorizeUrl.contains("?")){
			return true;
		}
		return false;
	}
	
}
