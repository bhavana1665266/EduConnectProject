package com.wecp.progressive.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.wecp.progressive.entity.User;
import com.wecp.progressive.repository.UserRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final UserRepository userRepository;
@Autowired
public JwtUtil(UserRepository userRepository)
{
    this.userRepository = userRepository;
}
    private final String secret = "KrishnaChaitanya00000000000000000000000000000000000000000000000000000000000000000000000000"; // Secret key for signing JWT
    private final int expiration = 86400 * 1000; // Token expiration (24 hours in ms)

    // Generate token with username
    public String generateToken(String username) {
        Date now =new Date();
        Date expirayDate=new Date(now.getTime()+expiration*1000);
        User user=userRepository.findByUsername(username);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getUserId());
        claims.put("role", user.getRole());
        return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(expirayDate)
        .signWith(SignatureAlgorithm.HS512,secret)
        .compact();
    }

    // private String createToken(Map<String, Object> claims, String subject) {
    //     return Jwts.builder()
    //             .setClaims(claims)
    //             .setSubject(subject) // username
    //             .setIssuedAt(new Date(System.currentTimeMillis()))
    //             .setExpiration(new Date(System.currentTimeMillis() + expiration))
    //             .signWith(SignatureAlgorithm.HS256, secret)
    //             .compact();
    // }

    // Extract all claims
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    // Extract username from token
    // public String extractUsername(String token) {
    //     return extractClaim(token, Claims::getSubject);
    // }

    // Generic method to extract a claim
    // public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    //     final Claims claims = extractAllClaims(token);
    //     return claimsResolver.apply(claims);
    // }

    // Check if token has expired
    public boolean isTokenExpired(String token) {
        Date expirationDate=extractAllClaims(token).getExpiration();
        return expirationDate.before(new Date());
    }

    // private Date extractExpiration(String token) {
    //     return extractClaim(token, Claims::getExpiration);
    // }

    // Validate token with UserDetails
    public boolean validateToken(String token, UserDetails userDetails) {
        Claims claims=extractAllClaims(token);
        Integer tokenuserId=(Integer) claims.get("userId");
 
        return (userDetails.getUsername().equals(String.valueOf(tokenuserId)) && !isTokenExpired(token));
    }
}
