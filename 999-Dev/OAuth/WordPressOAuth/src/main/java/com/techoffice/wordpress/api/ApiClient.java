package com.techoffice.wordpress.api;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getSites() throws ApiClientException{
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		String token = TokenUtil.getToken();
		String sitesjsonReturn = ApiClientUtil.getApiReturn(ApiUrlConstants.ME_SITES, token);
		Map<String, Object> sitesjsonMap = JsonUtil.toMap(sitesjsonReturn);
		Object sites = sitesjsonMap.get("sites");
		results = (List<Map<String, Object>>) sites;
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getPosts(String siteId) throws ApiClientException{
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		String token = TokenUtil.getToken();
		String listSitePostsUrl = MessageFormat.format(ApiUrlConstants.SITES_SITE_POST, siteId);
		String postsjsonReturn = ApiClientUtil.getApiReturn(listSitePostsUrl, token);
		Map<String, Object> postsjsonMap = JsonUtil.toMap(postsjsonReturn);
		Object posts = postsjsonMap.get("posts");
		results = (List<Map<String, Object>>) posts;
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getPosts(String siteId, int page) throws ApiClientException{
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		String token = TokenUtil.getToken();
		String listSitePostsUrl = MessageFormat.format(ApiUrlConstants.SITES_SITE_POST, siteId);
		String postsjsonReturn = ApiClientUtil.getApiReturn(listSitePostsUrl + "?type=any&offset=" + page*20, token);
		Map<String, Object> postsjsonMap = JsonUtil.toMap(postsjsonReturn);
		Object posts = postsjsonMap.get("posts");
		results = (List<Map<String, Object>>) posts;
		return results;
	}
	
	public static List<Map<String, Object>> getAllPosts(String siteId) throws ApiClientException{
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		Map<String, Integer> pageCountMap = getPostCount(siteId);
		int totalCount = 0;
		int postPerPage = 20;
		totalCount = pageCountMap.get("count");
		int pageNum = (int) Math.ceil((double)totalCount / (double)postPerPage); 
		System.out.println("Post Count: " + totalCount + " pageNum: " + pageNum);
		for (int i=0; i<pageNum; i++){
			List<Map<String, Object>> result = getPosts(siteId, i);
			System.out.println("pageNum: " + i + " Result Count:" + result.size());
			results.addAll(result);
		}
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Integer> getPostCount(String siteId) throws ApiClientException{
		Map<String, Integer> result = new HashMap<String, Integer>();
		String token = TokenUtil.getToken();
		String postCountsPageUrl = MessageFormat.format(ApiUrlConstants.SITES_SITE_POSTCOUNTS, siteId, "page");
		String postCountsPostUrl = MessageFormat.format(ApiUrlConstants.SITES_SITE_POSTCOUNTS, siteId, "post");
		String postCountsPagejsonReturn = ApiClientUtil.getApiReturn(postCountsPageUrl, token);
		String postCountsPostjsonReturn = ApiClientUtil.getApiReturn(postCountsPostUrl, token);
		Map<String, Object> postCountsPageJsonMap = JsonUtil.toMap(postCountsPagejsonReturn);
		Map<String, Object> postCountsPostJsonMap = JsonUtil.toMap(postCountsPostjsonReturn);
		Map<String, Map<String, Integer>> pageCountMap = (Map<String, Map<String, Integer>>) postCountsPageJsonMap.get("counts");
		Map<String, Map<String, Integer>> postCountMap = (Map<String, Map<String, Integer>>) postCountsPostJsonMap.get("counts");
		Map<String, Integer> allPageCountMap = pageCountMap.get("all");
		Map<String, Integer> allPostCountMap = postCountMap.get("all");
		Integer pagePublishCount = allPageCountMap.get("publish");
		Integer pagePostCount = allPostCountMap.get("publish");
		Integer total = pagePublishCount + pagePostCount;
		result.put("count", total);
		return result;
	}
}
