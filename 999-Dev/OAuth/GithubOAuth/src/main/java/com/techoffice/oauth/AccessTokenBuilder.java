package com.techoffice.oauth;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.techoffice.Appl;

public class AccessTokenBuilder {
	
	private static String code;
	
	public static void setCode(String lCode){
		code = lCode;
	}
	
	private static String getAccessTokenUrl(){
		return Appl.TOKEN_URL + "?code=" + code + "&client_id=" + Appl.CLIENT_ID + "&client_secret=" + Appl.CLIENT_SECRET; 
	}
	
	public static String getToken() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
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

        String url = getAccessTokenUrl();
        System.out.println(url);
//        webClient.addRequestHeader("Accept", "application/xml");
        final UnexpectedPage page = webClient.getPage(url);
        final String pageAsXml = page.getWebResponse().getContentAsString();
        webClient.close();
        System.out.println(pageAsXml);
        Map<String, String> tokenMap = convertTokenMap(pageAsXml);
        String accessToken = tokenMap.get("access_token");
        ApiClient.setAccessToken(accessToken);
        return accessToken;
	}
	
	private static Map<String, String> convertTokenMap(String str){
		Map<String, String> map = new HashMap<String, String>();
		String[] tokenPairs= str.split("&");
		for (int i=0; i<tokenPairs.length; i++){
			String tokenPair = tokenPairs[i];
			String[] tokenPairArr = tokenPair.split("=");
			String key = tokenPairArr[0];
			String value = "";
			if (tokenPairArr.length > 1){
				value = tokenPairArr[1];
			}
			map.put(key, value);
		}
		return map;
	}
}
