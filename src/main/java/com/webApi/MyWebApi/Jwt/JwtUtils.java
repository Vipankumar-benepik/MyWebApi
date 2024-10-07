package com.webApi.MyWebApi.Jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;

    @Value("${spring.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    // Extract JWT from Authorization header
    public String getJwtFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        logger.debug("Authorization Header: {}", bearerToken);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Remove "Bearer " prefix
        }
        return null;
    }

    // Generate JWT token using username (subject)
    public String generateTokenFromUsername(UserDetails userDetails) {
        return generateToken(userDetails.getUsername());
    }

    // Generate token using a specific username
    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username) // Set username as subject
                .issuedAt(new Date()) // Current date/time
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs)) // Expiration time
                .signWith(getSigningKey()) // Sign with the key and HS256 algorithm
                .compact(); // Generate token
    }

    // Parse the JWT token and extract the username (subject)
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

//                .parserBuilder()
//                .setSigningKey(getSigningKey()) // Set the signing key
//                .build()
//                .parseClaimsJws(token) // Parse and validate the token
//                .getBody()
//                .getSubject(); // Extract the subject (username)
    }

    // Validate the JWT token
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(authToken);

//                    .parserBuilder()
//                    .setSigningKey(getSigningKey())
//                    .build()
//                    .parseClaimsJws(authToken);

            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    // Generate a key from the secret
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret); // Decode the Base64-encoded secret
        return Keys.hmacShaKeyFor(keyBytes); // Generate HMAC-SHA key
    }
}