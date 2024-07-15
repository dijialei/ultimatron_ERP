package com.ultimatron.erp.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class RedisUtil {
    private RedisTemplate<String, String> redisTemplate;

    public void createRedisCache(String email, String token) {
        redisTemplate.opsForSet().add(email, token);
    }

    public boolean verifyRedisCache(String email, String token) {
        return redisTemplate.opsForSet().isMember(email, token);
    }

    public void deleteRedisCache(String email, String token) {
        if (verifyRedisCache(email, token))
            redisTemplate.opsForSet().remove(email, token);
    }
}
