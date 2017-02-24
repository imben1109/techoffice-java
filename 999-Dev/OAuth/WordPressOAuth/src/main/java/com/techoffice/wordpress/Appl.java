package com.techoffice.wordpress;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.techoffice.common.util.JsonUtil;
import com.techoffice.wordpress.api.ApiClient;
import com.techoffice.wordpress.api.ApiUrlConstants;
import com.techoffice.wordpress.oauth.OAuthFlow;
import com.techoffice.wordpress.oauth.OAuthInfo;

/**
 * This is Wordpress.com OAuth Example
 * 
 * @author Ben_c
 *
 */
public class Appl {
	
	public static final String AUTHORIZE_URL = "https://public-api.wordpress.com/oauth2/authorize?response_type=code&scope=global";
	public static final String TOKEN_URL = "https://public-api.wordpress.com/oauth2/token";
	
	public static final String CLIENT_ID = "50479";
	public static final String CLIENT_SECRET = "urXsWEjCefIH7LWo0wLKeqnuvilIrJa2CN8VZasw93cimtSyQoNq2vLTBh39hm0I";
	
	public static final String APPL_URL = "http://localhost:8080";
	
	public static final String API_VALIDATE_TOKEN_URL = "https://public-api.wordpress.com/oauth2/token-info";
	public static final String API_USER_INFO_URL = "https://public-api.wordpress.com/rest/v1/me/";
	
	
	public static void main(String[] args) throws Exception{
		OAuthInfo oAuthInfo = new OAuthInfo(AUTHORIZE_URL, TOKEN_URL, CLIENT_ID, CLIENT_SECRET, APPL_URL, API_VALIDATE_TOKEN_URL);
		OAuthFlow oAuthFlow = new OAuthFlow(oAuthInfo);
		String token = oAuthFlow.requestAccessToken();
		System.out.println("Access Token: " + token);
		ApiClient.getApiReturn(API_USER_INFO_URL, token);
		String sitesjsonReturn = ApiClient.getApiReturn(ApiUrlConstants.ME_SITES, token);
		Map<String, Object> sitesjsonMap = JsonUtil.toMap(sitesjsonReturn);
		Object sites = sitesjsonMap.get("sites");
		if (sites instanceof List){
			List<Map<String, Object>> siteList = (List<Map<String, Object>>) sites;
			for (Map<String, Object> site: siteList){
				String id = site.get("ID").toString();
				String name = site.get("name").toString();
				String url = site.get("URL").toString();
				System.out.println(id + ": " + name + "(" + url + ")");
			}
//			String siteId = siteList.get(0).get("ID").toString();
//			String listSitePostsUrl = MessageFormat.format(ApiUrlConstants.SITES_SITE_POSIT, siteId);
//			String postsjsonReturn = ApiClient.getApiReturn(listSitePostsUrl, token);
//			Map<String, Object> postsjsonMap = JsonUtil.toMap(postsjsonReturn);
//			Object posts = postsjsonMap.get("posts");
//			if (sites instanceof List){
//				List<Map<String, Object>> postList = (List<Map<String, Object>>) posts;
//				for (Map<String, Object> post: postList){
//					String content = post.get("content").toString();
//					System.out.println(content);
//				}
//
//			}
		}
	}
	
}
