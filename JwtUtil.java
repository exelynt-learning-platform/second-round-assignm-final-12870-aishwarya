package com.example.demo.config;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;  

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	 @Value("${jwt.secret}")
         private String SECRET;

	    public String generateToken(String username) {
	        return Jwts.builder()
	                .setSubject(username)
	                .signWith(SignatureAlgorithm.HS256, SECRET)
	                .compact();
	    }

	    public String extractUsername(String token) 
	    {
	        return Jwts.parser()
	                .setSigningKey(SECRET)
	                .parseClaimsJws(token)
	                .getBody()
	                .getSubject();
 }
}
