package com.techoffice.wordpress.oauth.request;

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
import com.techoffice.common.util.JsonUtil;
import com.techoffice.htmlunit.WebClientFactory;
import com.techoffice.wordpress.Appl;
import com.techoffice.wordpress.config.ApplConfig;
import com.techoffice.wordpress.oauth.OAuthInfo;

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
	public static String getToken(OAuthInfo oAuthInfo, String code) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		
	    WebClient webClient = WebClientFactory.create();

        String url = oAuthInfo.getTokenUrl();
        System.out.println(url);
        // For wordpress, it require POST Method
        WebRequest requestSettings = new WebRequest(new URL(url), HttpMethod.POST);
        
        // 
        List<NameValuePair> requestParms = new ArrayList<NameValuePair>();
        requestParms.add(new NameValuePair("client_id", oAuthInfo.getClientId()));
        requestParms.add(new NameValuePair("client_secret", oAuthInfo.getClientSecret()));
        requestParms.add(new NameValuePair("code", code));
        requestParms.add(new NameValuePair("grant_type", "authorization_code"));
        requestParms.add(new NameValuePair("redirect_uri", oAuthInfo.getApplUrl()));
        requestSettings.setRequestParameters(requestParms);
        
        final UnexpectedPage page = webClient.getPage(requestSettings);
        final String pageAsXml = page.getWebResponse().getContentAsString();
        webClient.close();
        System.out.println(pageAsXml);
        Map<String, Object> tokenMap = JsonUtil.toMap(pageAsXml);
        Object accessToken = tokenMap.get("access_token");
        System.out.println("Access Token: " + accessToken);
        return accessToken.toString();
	}
	
}
