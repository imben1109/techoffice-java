package com.techoffice.github;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techoffice.github.factory.ProxyRestTemplateFactory;
import com.techoffice.github.util.StringUtil;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {
	
	private static final String clientSecret = "7657c6bbfb35e03661fe176c716197cb579db51a";
	private static final String clientId = "480856be9f03afee4633";
	private static final String redirectUrl = "http://localhost:8080/authenticate";
	private static final String authorizeUrl = "https://github.com/login/oauth/authorize";
	private static final String accessTokenUrl = "https://github.com/login/oauth/access_token";
	private static final String userInfoUrl = "https://api.github.com/user";

	@RequestMapping("/")
    public void home(HttpServletResponse httpServletResponse) throws IOException {
		String forwardUrl = authorizeUrl +"?client_id="+ clientId + "&redirect_uri=" + redirectUrl;
        httpServletResponse.sendRedirect(forwardUrl);
    }
	
	@RequestMapping("/authenticate")
	@ResponseBody
	String authenticate(@RequestParam(value = "code") String code){
		System.out.println("code");
		RestTemplate restTemplate = ProxyRestTemplateFactory.getRestTemplate();
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("client_id", clientId);
		requestMap.put("client_secret", clientSecret);
		requestMap.put("code", code);
		String result = restTemplate.postForObject(accessTokenUrl, requestMap, String.class);
		Map<String, String> resultMap = StringUtil.convertQueryStringToMap(result);
		String accessToken = resultMap.get("access_token");
		System.out.println("access token:" + accessToken);
		// 
		Map<String, String> userInfoRequestMap = new HashMap<String, String>();
		String userInfoResult = restTemplate.getForObject(userInfoUrl+"?access_token="+accessToken, String.class);
		
		System.out.println(userInfoResult);
		
		return code;
	}
	
	
	
	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
