package com.techoffice.wordpress.api;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techoffice.common.util.JsonUtil;
import com.techoffice.wordpress.api.constant.ApiUrlConstants;
import com.techoffice.wordpress.api.exception.ApiClientException;
import com.techoffice.wordpress.api.util.ApiClientUtil;
import com.techoffice.wordpress.oauth.util.TokenUtil;

public class ApiClient {
	
	public static final String API_USER_INFO_URL = "https://public-api.wordpress.com/rest/v1/me/";

	
	public static String getUserInfo() throws ApiClientException{
		String token = TokenUtil.getToken();
		return ApiClientUtil.getApiReturn(API_USER_INFO_URL, token);
	}
	
	public static List<Map<String, String>> getSites() throws ApiClientException{
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		String token = TokenUtil.getToken();
		String sitesjsonReturn = ApiClientUtil.getApiReturn(ApiUrlConstants.ME_SITES, token);
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
		}
		return result;
	}
	
	public static void test(String siteId) throws ApiClientException{
		String token = TokenUtil.getToken();
		String listSitePostsUrl = MessageFormat.format(ApiUrlConstants.SITES_SITE_POSIT, siteId);
		String postsjsonReturn = ApiClientUtil.getApiReturn(listSitePostsUrl, token);
		Map<String, Object> postsjsonMap = JsonUtil.toMap(postsjsonReturn);
		Object posts = postsjsonMap.get("posts");
		if (posts instanceof List){
			List<Map<String, Object>> postList = (List<Map<String, Object>>) posts;
			for (Map<String, Object> post: postList){
				String content = post.get("content").toString();
				System.out.println(content);
			}
		}
	}
}
