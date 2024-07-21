package com.ultimatron.erp.authentication;

import com.ultimatron.erp.config.JwtConfig;
import com.ultimatron.erp.entities.Users;
import com.ultimatron.erp.utils.JwtUtil;
import com.ultimatron.erp.utils.RedisUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class LoginService {
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private JwtConfig jwtConfig;
    private RedisUtil redisUtil;

    public ResponseEntity login(Users user) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authentication)) return ResponseEntity.status(403).body("Username or password error !");
        else {
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            user = loginUser.getUser();
            String jwtToken = jwtUtil.buildJwt(user);
            redisUtil.createRedisCache(user.getEmail(), jwtToken);
            Map<String, String> map = new HashMap<>();
            map.put(jwtConfig.getName(), jwtToken);
            map.put("Username", user.getLastName() + " " + user.getFirstName());
            return ResponseEntity.status(200).body(map);
        }
    }

    public ResponseEntity signout(HttpHeaders httpHeaders) {
        String token = httpHeaders.get(jwtConfig.getName()).get(0);
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        redisUtil.deleteRedisCache(loginUser.getUser().getEmail(), token);
        return ResponseEntity.status(200).body("signout ! ");
    }

}
