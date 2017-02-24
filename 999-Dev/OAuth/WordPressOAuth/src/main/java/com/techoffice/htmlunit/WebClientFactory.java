package com.techoffice.htmlunit;

import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.techoffice.wordpress.config.ApplConfig;

/**
 * Web Client Factory 
 * 
 * @author Ben_c
 *
 */
public class WebClientFactory {
	
	public static WebClient create(){
	    WebClient webClient = new WebClient();
	    if (ApplConfig.config.getBoolean(ApplConfig.PROXY_ENABLED, false)){
	    	ProxyConfig proxyConfig = new ProxyConfig(
		    		ApplConfig.config.getString(ApplConfig.PROXY_HOST), 
		    		ApplConfig.config.getInt(ApplConfig.PROXY_PORT));
		    webClient.getOptions().setProxyConfig(proxyConfig);
	        final DefaultCredentialsProvider credentialsProvider = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
	        credentialsProvider.addCredentials(
	        		ApplConfig.config.getString(ApplConfig.PROXY_USERNAME), 
	        		ApplConfig.config.getString(ApplConfig.PROXY_PASSWORD));	
	    }
	    LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
	    return webClient;
	}
}
