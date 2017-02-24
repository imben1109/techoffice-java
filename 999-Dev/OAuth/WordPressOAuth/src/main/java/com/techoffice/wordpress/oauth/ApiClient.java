package com.techoffice.wordpress.oauth;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.techoffice.htmlunit.WebClientFactory;
import com.techoffice.wordpress.config.ExampleConfig;

public class ApiClient {
	
	private static String accessToken;
	
	public static void setAccessToken(String lAccessToken){
		accessToken = lAccessToken;
	}
	
	public static String getApiReturn(String apiURL) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
	    WebClient webClient = WebClientFactory.create();
	    
        WebRequest requestSettings = new WebRequest(new URL(apiURL), HttpMethod.GET);
        requestSettings.setAdditionalHeader("Authorization", "BEARER " + accessToken);
        
        final UnexpectedPage page = webClient.getPage(requestSettings);
        final String pageAsXml = page.getWebResponse().getContentAsString();
        webClient.close();
        
        System.out.println(pageAsXml);
        return pageAsXml;
	}
}
