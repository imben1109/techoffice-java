package com.techoffice.example;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Appl {
	public static void main(String[] args) throws IOException {
		HttpClient client; 
	    if (ExampleConfig.config.getBoolean(ExampleConfig.PROXY_ENABLED, false)){
			HttpHost proxy = new HttpHost(
					ExampleConfig.config.getString(ExampleConfig.PROXY_HOST), 
					ExampleConfig.config.getInt(ExampleConfig.PROXY_PORT));
			Credentials credentials = new UsernamePasswordCredentials(ExampleConfig.config.getString(ExampleConfig.PROXY_USERNAME),
					ExampleConfig.config.getString(ExampleConfig.PROXY_PASSWORD));
			AuthScope authScope = new AuthScope(ExampleConfig.config.getString(ExampleConfig.PROXY_HOST), 
					ExampleConfig.config.getInt(ExampleConfig.PROXY_PORT));
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(authScope, credentials);
			client = HttpClientBuilder.create().setProxy(proxy).setDefaultCredentialsProvider(credsProvider).build();
	    }else{
	    	client = HttpClientBuilder.create().build();
	    }
		HttpResponse response= client.execute(new HttpGet("http://httpbin.org/get"));
        System.out.println(EntityUtils.toString(response.getEntity()));

	}
}
