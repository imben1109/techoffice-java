package com.ittechoffice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableOAuth2Sso
@Controller
public class SimpleAppl {

	@Autowired
	private OAuth2ClientContext oauth2ClientContext;

	@Autowired
	private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;
	
	@RequestMapping("/run")
	@ResponseBody
	public String run(){
		OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(oAuth2ProtectedResourceDetails, oauth2ClientContext);
		String result = oAuth2RestTemplate.getForObject("https://graph.facebook.com/me", String.class);
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleAppl.class, args);
	}
}
