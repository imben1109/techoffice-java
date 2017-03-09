package com.techoffice.wordpress.oauth;

public class OAuthInfo {
	
	private String authorizeUrl;
	private String tokenUrl;
	private String clientSecret;
	private String clientId;
	private String applUrl;
	private String tokenValidateUrl;
	
	public OAuthInfo(String authorizeUrl, String tokenUrl, String clientId, String clientSecret, String applUrl, String tokenValidateUrl){
		this.authorizeUrl = authorizeUrl;
		this.tokenUrl = tokenUrl;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.applUrl = applUrl;
		this.tokenValidateUrl = tokenValidateUrl;
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

	public String getTokenValidateUrl() {
		return tokenValidateUrl;
	}

	public void setTokenValidateUrl(String tokenValidateUrl) {
		this.tokenValidateUrl = tokenValidateUrl;
	}
	
	

}
