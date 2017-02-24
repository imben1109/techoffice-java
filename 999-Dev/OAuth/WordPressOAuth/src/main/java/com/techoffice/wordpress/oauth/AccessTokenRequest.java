package com.techoffice.wordpress.oauth;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.techoffice.wordpress.Appl;
import com.techoffice.wordpress.config.ApplConfig;

/**
 * This Class represents the Access Token Request to obtain access token. 
 * 
 * @author Ben_c
 *
 */
public class AccessTokenRequest {

	/**
	 * This method is to obtain token by HTMLUnit
	 * 
	 * @param code
	 * @return access token
	 * 
	 * @throws FailingHttpStatusCodeException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String getToken(String code) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
	    final WebClient webClient = new WebClient();
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

        String url = Appl.TOKEN_URL;
        System.out.println(url);
        // For wordpress, it require POST Method
        WebRequest requestSettings = new WebRequest(new URL(url), HttpMethod.POST);
        
        // 
        List<NameValuePair> requestParms = new ArrayList<NameValuePair>();
        requestParms.add(new NameValuePair("client_id", Appl.CLIENT_ID));
        requestParms.add(new NameValuePair("client_secret", Appl.CLIENT_SECRET));
        requestParms.add(new NameValuePair("code", code));
        requestParms.add(new NameValuePair("grant_type", "authorization_code"));
        requestParms.add(new NameValuePair("redirect_uri", Appl.APPL_URL));
        requestSettings.setRequestParameters(requestParms);
        
        final UnexpectedPage page = webClient.getPage(requestSettings);
        final String pageAsXml = page.getWebResponse().getContentAsString();
        webClient.close();
        System.out.println(pageAsXml);
        Map<String, String> tokenMap = convertTokenMap(pageAsXml);
        String accessToken = tokenMap.get("access_token");
        System.out.println("accessToken: " + accessToken);
        return accessToken;
	}
	
	
	private static Map<String, String> convertTokenMap(String str){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = new HashMap<String, String>();
		try {
			map = mapper.readValue(str, new TypeReference<Map<String, String>>(){});
		} catch (Exception e) {
			System.err.println("Cannot convert Json to Map");
		}
		return map;
	}
}
