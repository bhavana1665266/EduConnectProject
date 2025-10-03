package com.wecp.progressive.util;
import com.wecp.progressive.model.User;
import com.wecp.progressive.repository.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtUtil {
    private final UserRepository userRepository;
    private final String secret = "secretKey000000secretKey000000secretKey000000"; // Must be at least 256 bits
    private final int expiration = 86400 * 1000; // 24 hours in milliseconds
    private final Key key = Keys.hmacShaKeyFor(secret.getBytes());
    @Autowired
    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Generate JWT token with claims
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found: " + username);
        }
        claims.put("roles", user.getRoles());
        claims.put("userId", user.getId());
        claims.put("studentId", user.getStudentId());
        claims.put("teacherId", user.getTeacherId());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    // Extract all claims from token
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    // Extract username from token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }
    // Check if token is expired
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
    // Validate token against user details
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
 
