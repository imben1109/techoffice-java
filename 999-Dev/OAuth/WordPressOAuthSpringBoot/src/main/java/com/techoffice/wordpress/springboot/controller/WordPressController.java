package com.techoffice.wordpress.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.techoffice.wordpress.api.ApiClient;
import com.techoffice.wordpress.api.exception.ApiClientException;

@Controller
@RequestMapping("wordpress")
public class WordPressController {
	
	@RequestMapping("/")
	public ModelAndView home() throws ApiClientException{
		ModelAndView model = new ModelAndView("wordpress");
		List<Map<String, Object>> sites = ApiClient.getSites();
		model.addObject("sites", sites);
		return model;
	}
	
	@RequestMapping("site")
	public ModelAndView site(@RequestParam(name="siteId") String siteId) throws ApiClientException{
		ModelAndView model = new ModelAndView("site");
		List<Map<String, Object>> posts = ApiClient.getAllPosts(siteId);
		model.addObject("posts", posts);
		return model;
	}
	
	@RequestMapping("sites")
	@ResponseBody
	public List<Map<String, Object>> sites() throws ApiClientException{
		List<Map<String, Object>> sites = ApiClient.getSites();
		return sites;
	}
	
	@RequestMapping("posts")
	@ResponseBody
	public List<Map<String, Object>> posts(@RequestParam(name="siteId") String siteId) throws ApiClientException {
		List<Map<String, Object>> posts = ApiClient.getAllPosts(siteId);
		return posts;
	}
	
	@RequestMapping("postCount")
	@ResponseBody
	public Map<String, Integer> postCount(@RequestParam(name="siteId") String siteId) throws ApiClientException {
		Map<String, Integer> posts = ApiClient.getPostCount(siteId);
		return posts;
	}
	
	
}
