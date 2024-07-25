package com.ultimatron.erp.config;

import com.ultimatron.erp.authentication.LoginUser;
import com.ultimatron.erp.entities.Users;
import com.ultimatron.erp.utils.JwtUtil;
import com.ultimatron.erp.utils.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.List;

@Configuration
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private JwtConfig jwtConfig;
    private JwtUtil jwtUtil;
    private HandlerExceptionResolver handlerExceptionResolver;
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(jwtConfig.getName());
        if (StringUtils.hasText(token)) {
            Claims body;
            try {
                body = jwtUtil.parseJwt(token);
            } catch (ExpiredJwtException e) {
                redisUtil.deleteRedisCache((String) e.getClaims().get("email"), token);
                handlerExceptionResolver.resolveException(request, response, null, e);
                return;
            } catch (JwtException e) {
                handlerExceptionResolver.resolveException(request, response, null, e);
                return;
            }
            if (redisUtil.verifyRedisCache((String) body.get("email"),token)){
                Users user = new Users();
                user.setEmail((String) body.get("email"));
                user.setId(Integer.valueOf(body.getSubject()));
                user.setRoles((List<String>) body.get("roles"));
                LoginUser loginUser = new LoginUser(user);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }else
                handlerExceptionResolver.resolveException(request,response,null,new RuntimeException("Token signed out !"));
        }
        filterChain.doFilter(request, response);
    }
}
