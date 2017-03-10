package com.techoffice.wordpress.api.util;

import java.net.URL;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.techoffice.htmlunit.WebClientFactory;
import com.techoffice.wordpress.api.exception.ApiClientException;

public class ApiClientUtil {
	
	public static String getApiReturn(String url, String accessToken) throws ApiClientException{
	    WebClient webClient = WebClientFactory.create();
	    String response = null;
		try {
	        WebRequest requestSettings = new WebRequest(new URL(url), HttpMethod.GET);
	        requestSettings.setAdditionalHeader("Authorization", "BEARER " + accessToken);
	        
	        UnexpectedPage page;
			page = webClient.getPage(requestSettings);
	        response = page.getWebResponse().getContentAsString();
		} catch (Exception e) {
			throw new ApiClientException(url, accessToken);
		} finally {
	        webClient.close();
		}
        return response;
	}
	
}
