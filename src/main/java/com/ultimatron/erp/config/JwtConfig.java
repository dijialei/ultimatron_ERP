package com.ultimatron.erp.config;

import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Configuration
@Getter
@Setter
public class JwtConfig {
 @Value("${jwt.expires_in}")
 private long expireIn;
 @Value("${jwt.cookie}")
 private String cookie;
 @Value("${jwt.name}")
 private String name;
 @Value("${jwt.secret}")
 private String secret;
private Key secretKey;
@PostConstruct
 public void buildKey(){
 secretKey = new SecretKeySpec(Base64.getDecoder().decode(getSecret()), SignatureAlgorithm.HS256.getJcaName());
}
}
