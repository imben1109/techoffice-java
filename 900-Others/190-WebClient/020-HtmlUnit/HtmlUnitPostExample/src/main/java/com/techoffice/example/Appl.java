package com.techoffice.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

/**
 * This Example show how to use HtmlUnit to post data to a test web page 
 * 	http://httpbin.org/post
 * This web service would return the post data 
 * 
 * @author Ben_c
 *
 */
public class Appl {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
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

        String url = "http://httpbin.org/post";
        WebRequest requestSettings = new WebRequest(new URL(url), HttpMethod.POST);
        NameValuePair param = new NameValuePair("ABC", "CDE");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(param);
        requestSettings.setRequestParameters(params);
        
        final UnexpectedPage page = webClient.getPage(requestSettings);
        final String pageAsXml = page.getWebResponse().getContentAsString();
        System.out.println(pageAsXml);
        webClient.close();
	}
}
