package com.techoffice.example.util;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class ProxyUtil {
	public static String USE_SYSTEM_PROXIES = "java.net.useSystemProxies";

	public static Proxy detectSystemProxy(String url) throws URISyntaxException{
		// java.net.useSystemProxies is configuration that tells java.net to use system proxy setting.
		String useSystemProxies = System.getProperty(USE_SYSTEM_PROXIES);
		if (!"true".equals(useSystemProxies)){
			useSystemProxies = "false";
		}
		System.setProperty(USE_SYSTEM_PROXIES, "true");
	    List<Proxy> proxyList = ProxySelector.getDefault().select(new URI(url));
	    Proxy proxy = null;
	    if (proxyList.size() > 0){
	    	proxy = proxyList.get(0);
			InetSocketAddress addr = (InetSocketAddress) proxy.address();
			System.out.println("System proxy: " + addr.getHostName() + ":" + addr.getPort());

	    }
		System.setProperty(USE_SYSTEM_PROXIES, useSystemProxies);
				
		return proxy;
	}
	
}
