package jp.co.pokemon.config;

import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.core.*;
import org.springframework.session.data.redis.config.annotation.web.http.*;

@Configuration
@AllArgsConstructor
@EnableRedisHttpSession
public class SpringDataRedisClientConfig {
    private final RedisProperties redisProperties;

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}

