package com.techoffice.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.techoffice.security.util.JwtUtil;
import com.techoffice.security.util.KeyUtil;

//@Configuration
public class Config {

//	@Value("${secretKey}")
//	private String secretKey;
//	
//	@PostConstruct
//	public void init(){
//		JwtUtil.setSecretKey(KeyUtil.decodeKey(secretKey));
//	}
}
