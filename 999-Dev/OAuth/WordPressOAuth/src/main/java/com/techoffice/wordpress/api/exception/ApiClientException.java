package com.techoffice.wordpress.api.exception;

public class ApiClientException extends Exception{
	
	private static final long serialVersionUID = 88290397729470184L;

	public ApiClientException(String url, String accessToken){
		super("Fail to Get Response from url: " + url + " with access token: " + accessToken);
	}
}
