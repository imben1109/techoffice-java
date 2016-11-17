package com.techoffice.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import com.techoffice.example.util.ProxyUtil;

public class Appl {
	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException{
		Proxy systemProxy = ProxyUtil.detectSystemProxy("http://httpbin.org/get");
		InetSocketAddress addr = (InetSocketAddress) systemProxy.address();
	}
}
