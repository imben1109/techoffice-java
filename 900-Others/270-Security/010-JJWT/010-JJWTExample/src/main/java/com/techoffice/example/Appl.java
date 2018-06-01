package com.techoffice.example;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * JWT is a means of transmitting information between two parties in compact and verifiable form
 * 
 * e.g. 
 * 
 * JWT would transfer a token to another party
 * 		eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKb2UifQ.DpekFPS05Ve6rcqj8pHpPa6cmvY849iPIJ_dMzzEcNl0hoIN_vB8cJwGgCtiG_ZxePkIVCiDYinHtCa4YsXbGw
 * It would represent a header information and body information
 * 
 * Header
 * {alg=HS512}
 * 
 * 
 * Body
 * {sub=Job}
 * 
 * @author imben1109
 *
 */
public class Appl {
	public static void main(String[] args){
		Key key = MacProvider.generateKey();
		String compactJws = Jwts.builder()
				.setSubject("Joe")
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();
		System.out.println("" + compactJws);
		
	    Jws<Claims> claims = Jwts.parser()
	    		.requireSubject("Joe")
	    		.setSigningKey(key)
	    		.parseClaimsJws(compactJws);
	    
	    System.out.println(claims.getBody().toString());
	    System.out.println(claims.getHeader().toString());
	    
	}
}
