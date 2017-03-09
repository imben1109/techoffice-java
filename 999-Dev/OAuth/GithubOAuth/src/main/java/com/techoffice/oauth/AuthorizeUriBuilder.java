package com.techoffice.oauth;

import java.net.URI;
import java.net.URISyntaxException;

public class AuthorizeUriBuilder {

	public static URI build(String authorizeUrl, String clientId, String redirectUrl){
		String uriStr = authorizeUrl + "?" + ParameterConstant.CLIENT_ID + "=" + clientId + "&" + ParameterConstant.REDIRECT_URI + "=" + redirectUrl;
		URI uri = null;
		try {
			uri = new URI(uriStr);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return uri;
	}
	
}
