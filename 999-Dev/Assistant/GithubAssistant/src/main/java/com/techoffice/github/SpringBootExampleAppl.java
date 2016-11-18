package com.techoffice.github;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {
	
	private static final String clientId = "480856be9f03afee4633";
	private static final String redirectUrl = "http://localhost:8080/authenticate";
	private static final String authorizeUrl = "https://github.com/login/oauth/authorize";

	@RequestMapping("/")
	@ResponseBody
    String home() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        return "Hello World!";
    }
	
	@RequestMapping("/authenticate")
	@ResponseBody
	String authenticate(@RequestParam(value = "code") String code){
		return code;
	}
	
	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
