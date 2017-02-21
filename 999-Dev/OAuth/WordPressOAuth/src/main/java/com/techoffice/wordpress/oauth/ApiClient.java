package com.techoffice.wordpress.oauth;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;

public class ApiClient {
	
	private static String accessToken;
	
	public static void setAccessToken(String lAccessToken){
		accessToken = lAccessToken;
	}
	
	public static String getApiReturn(String apiURL) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
	    final WebClient webClient = new WebClient();
	    if (ExampleConfig.config.getBoolean(ExampleConfig.PROXY_ENABLED, false)){
	    	ProxyConfig proxyConfig = new ProxyConfig(
		    		ExampleConfig.config.getString(ExampleConfig.PROXY_HOST), 
		    		ExampleConfig.config.getInt(ExampleConfig.PROXY_PORT));
		    webClient.getOptions().setProxyConfig(proxyConfig);
	        final DefaultCredentialsProvider credentialsProvider = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
	        credentialsProvider.addCredentials(
	        		ExampleConfig.config.getString(ExampleConfig.PROXY_USERNAME), 
	        		ExampleConfig.config.getString(ExampleConfig.PROXY_PASSWORD));	
	    }
	    LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

//        webClient.addRequestHeader("Accept", "application/xml");
        final UnexpectedPage page = webClient.getPage(apiURL + "?access_token=" + accessToken);
        final String pageAsXml = page.getWebResponse().getContentAsString();
        webClient.close();
        System.out.println(pageAsXml);
        return pageAsXml;
	}
}
