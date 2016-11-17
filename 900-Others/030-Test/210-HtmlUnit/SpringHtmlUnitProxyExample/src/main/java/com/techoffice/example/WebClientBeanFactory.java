package com.techoffice.example;

import org.springframework.beans.factory.FactoryBean;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.techoffice.example.config.ApplConfig;


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
