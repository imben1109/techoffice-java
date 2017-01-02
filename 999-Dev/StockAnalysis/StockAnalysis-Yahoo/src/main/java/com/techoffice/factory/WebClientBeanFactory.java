package com.techoffice.factory;

import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.FactoryBean;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.techoffice.config.ApplConfig;


public class WebClientBeanFactory implements FactoryBean<WebClient> {
	private WebClient webClient;
	
	public WebClientBeanFactory(){
		webClient = new WebClient(BrowserVersion.FIREFOX_45);
		
		if (ApplConfig.isProxyEnabled()){
	    	ProxyConfig proxyConfig = new ProxyConfig(
	    			ApplConfig.config.getString(ApplConfig.PROXY_HOST), 
	    			ApplConfig.config.getInt(ApplConfig.PROXY_PORT));
		    webClient.getOptions().setProxyConfig(proxyConfig);
	        final DefaultCredentialsProvider credentialsProvider = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
	        credentialsProvider.addCredentials(
	        		ApplConfig.config.getString(ApplConfig.PROXY_USERNAME), 
	        		ApplConfig.config.getString(ApplConfig.PROXY_PASSWORD));	
		}
		if (!ApplConfig.isHtmlUnitLogging()){
			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
	        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
	        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
		}
		
	}
	
	public WebClient getObject() throws Exception {
		return webClient;
	}

	public Class<?> getObjectType() {
		return webClient.getClass();
	}

	public boolean isSingleton() {
		return true;
	}

}
