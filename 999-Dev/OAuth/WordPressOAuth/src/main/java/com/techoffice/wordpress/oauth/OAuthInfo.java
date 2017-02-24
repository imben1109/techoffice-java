package com.techoffice.wordpress.oauth;

public class OAuthInfo {
	
	private String authorizeUrl;
	private String tokenUrl;
	private String clientSecret;
	private String clientId;
	private String applUrl;
	
	public OAuthInfo(String authorizeUrl, String tokenUrl, String clientId, String clientSecret, String APPL_URL){
		this.authorizeUrl = authorizeUrl;
		this.tokenUrl = tokenUrl;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}
	
	private String redirectUrl = "http://localhost:8080";

	public String getAuthorizeUrl() {
		return authorizeUrl;
	}

	public void setAuthorizeUrl(String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getApplUrl() {
		return applUrl;
	}

	public void setApplUrl(String applUrl) {
		this.applUrl = applUrl;
	}
	
	

}
