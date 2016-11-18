package com.techoffice.github.factory;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.techoffice.github.config.Config;

public class ProxyRestTemplateFactory {
	public static RestTemplate getRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
	    if (Config.config.getBoolean(Config.PROXY_ENABLED)){
	        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		    InetSocketAddress address = new InetSocketAddress(Config.config.getString(Config.PROXY_HOST), 
		    		Config.config.getInt(Config.PROXY_PORT));
	        Proxy proxy = new Proxy(Proxy.Type.HTTP,address);
	        factory.setProxy(proxy);
	        restTemplate.setRequestFactory(factory);
	    }
		return restTemplate;
	}
}
