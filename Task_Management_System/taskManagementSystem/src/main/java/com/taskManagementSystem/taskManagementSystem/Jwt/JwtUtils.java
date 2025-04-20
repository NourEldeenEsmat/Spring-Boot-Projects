package com.taskManagementSystem.taskManagementSystem.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;
@Component
public class JwtUtils {
    private final String SECRET_KEY = "Nour Kamel";

    private String createToken(String subject) {
        return Jwts.builder().setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System
                        .currentTimeMillis() + 1000 * 60 * 60 * 10)).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public String generateToken(String userName) {
        return createToken(userName);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY).parseClaimsJwt(token).getBody();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimSolver) {
        Claims claims = extractAllClaims(token);
        return claimSolver.apply(claims);
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Date extractExpireDate(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpireDate(token).before(new Date(System.currentTimeMillis()));
    }

    public boolean validateToken(String token, String userName) {
        String extractUserName = extractUserName(token);

        return (extractUserName.equals(userName) && !isTokenExpired(token));

    }
}
