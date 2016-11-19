package com.techoffice.example;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;

import com.techoffice.example.util.ProxyUtil;

/**
 * This example would demonstrate how Java Application detects proxy setting information
 * @author Ben_c
 *
 */
public class App {
	
	public static void main(String[] args) throws URISyntaxException{
		Proxy proxy = ProxyUtil.detectSystemProxy("https://www.google.com");
		if (proxy != null){
			InetSocketAddress addr = (InetSocketAddress) proxy.address();
			System.out.println(addr.getHostName());
			System.out.println(addr.getPort());
		}
	}

}
