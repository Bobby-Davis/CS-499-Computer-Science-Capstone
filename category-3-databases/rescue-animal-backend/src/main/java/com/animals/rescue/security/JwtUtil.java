package com.animals.rescue.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    
    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // generates a JWT token for the given user
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)                                   // who the token is for
                .setIssuedAt(new Date())                                // when the token is issued
                .setExpiration(new Date(System.currentTimeMillis()      // when the token will expire
                     + 1000 * 60 * 60 * 10))                            // token expires in 10 hours
                .signWith(SECRET_KEY)                                   // signs token with HMAC SHA-256 algorithm
                .compact();                                             // builds token string
    }

    // Extracts the username from token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Checks if the token is expired
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // Makes sure token is valid and belongs to the correct user
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // Extracts all data embedded in the token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody(); 
    }

    
}
