package com.techoffice.security.jwt;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	private static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public static Key getSecretKey(){
		return JwtUtil.secretKey;
	}
	
	public static Claims parseClaims(String token){
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		return claims;
	}
	
	public static Authentication parseAuthentication(String token){
		Claims claims = parseClaims(token);
		String username = claims.getSubject();
		if (username != null){
			String authoritiesStr = claims.get("authorities").toString();
			List<String> authoritiesList = Arrays.asList(authoritiesStr.split(","));
			Collection<GrantedAuthority> authorities = authoritiesList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
			return authToken;
		}
		return null;
	}
}
