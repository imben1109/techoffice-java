package com.techoffice.htmlunit;

import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.techoffice.wordpress.config.ExampleConfig;

/**
 * Web Client Factory 
 * 
 * @author Ben_c
 *
 */
public class WebClientFactory {
	
	public static WebClient create(){
	    WebClient webClient = new WebClient();
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
	    return webClient;
	}
}
