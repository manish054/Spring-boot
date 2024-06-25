package com.manish.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Service
public class JwtService {
	
	/*VID - 276 
	 * A JWT (Json web token) consists of 3 parts
	 * 1. head 
	 * 		type:
	 * 2. payload
	 * 3. signature
	 * 
	 * for these we can use some library for Jwt generation
	 * 
	 *  groupId - io.jsonwebtoken
	 *  artifact - jjwt-api
	 *  
	 *  we need implementation too as its an API
	 *  artifact - jjwt-imp
	 *  
	 *  somtimes json conversion issue happen so keep this dependency too
	 *  artifact - jjwt-jakson
	 *  
	 *  */
	
	//static secret key
	public static final String SECRET = "ttavbdwgyTwrdew56472364";
	
	private String secretKey;
	
	public JwtService() {
		secretKey = generateSecretKey();
	}
	//generating secrect key randomly
	public String generateSecretKey() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
			SecretKey secretKey = keyGenerator.generateKey();
			System.out.println("secretKey---"+secretKey);
			return Base64.getEncoder().encodeToString(secretKey.getEncoded());
		}catch(Exception e) {
			throw new RuntimeException("Error in generating secret key");
		}
	}
	
	
	public String generateToken(String username) {
		
		Map<String, Object> claims = new HashMap<>();
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getKey() {
		
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String extractUserName(String token) {
        // extract the username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build().parseClaimsJws(token).getBody();
    }


    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}
