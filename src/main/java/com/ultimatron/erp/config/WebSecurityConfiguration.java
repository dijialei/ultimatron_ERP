package com.ultimatron.erp.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Data

public class WebSecurityConfiguration {
    private final AuthenticationConfiguration configuration;

    @Bean
    public SecurityFilterChain securityFilterChai(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        auth -> auth
                                .anyRequest().permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(
                        sm -> sm
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        String encoderId = "bcrypt";
        Map<String,PasswordEncoder> encoders= new HashMap<>();
        encoders.put("bcrypt",new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(encoderId,encoders);
    }
    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return configuration.getAuthenticationManager();
    }

}
