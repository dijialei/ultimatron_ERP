package com.ultimatron.erp.config;

import com.ultimatron.erp.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Configuration
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private JwtConfig jwtConfig;
    private JwtUtil jwtUtil;
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(jwtConfig.getName());
        if (StringUtils.hasText(token)) {

        }
        filterChain.doFilter(request, response);
    }
}
