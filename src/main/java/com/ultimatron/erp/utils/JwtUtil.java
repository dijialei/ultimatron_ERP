package com.ultimatron.erp.utils;

import com.ultimatron.erp.config.JwtConfig;
import com.ultimatron.erp.entities.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
@AllArgsConstructor
public class JwtUtil {
    private JwtConfig jwtConfig;

    public String buildJwt(Users user) {
        List<String> roles = new ArrayList<>(user.getRoles());
        Map map = new HashMap();
        map.put("nickName", user.getNickName());
        map.put("email",user.getEmail());
        map.put("roles", roles);
        String token = Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setHeaderParam("alg", "HS265")
                .setSubject(String.valueOf(user.getId()))
                .addClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpireIn() * 1000))
                .signWith(jwtConfig.getSecretKey())
                .compact();
        return token;

    }

    public Claims parseJwt(String token) {
        JwtParser parser = Jwts.parserBuilder().setSigningKey(jwtConfig.getSecretKey()).build();
        Jws<Claims> claims = parser.parseClaimsJws(token);
        return claims.getBody();
    }
}
