package jp.co.pokemon.repository;

import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.*;
import org.springframework.stereotype.*;

import java.util.concurrent.*;

@Repository
public class RedisRepository {
    private StringRedisTemplate redisTemplate;
//    private RedisTemplate<String, XxxEntity> redisTemplateSerialize;
    private HashOperations<String, String, String> hashOps;

    public RedisRepository(StringRedisTemplate stringRedisTemplate,
                                       RedisConnectionFactory redisConnectionFactory) {
        this.redisTemplate = stringRedisTemplate;
//        this.redisTemplateSerialize = pinCodeCredentialRedisTemplate(redisConnectionFactory);
        this.hashOps = stringRedisTemplate.opsForHash();
    }

//    public String findPinCode(String key) {
//        return hashOps.get(key);
//    }

    public void save(String token, String category, String value) {
        hashOps.put(token, category, value);
    }

//    public XxxEntity findPinCodeCredential(String key) {
//        return (XxxEntity) redisTemplateSerialize.opsForHash().get(key);
//    }

//    public void savePinCodeCredential(String key, XxxEntity xxxEntity) {
//        redisTemplateSerialize.opsForHash().put();
//    }

    private void setExpireTimeLimit(String key) {
        redisTemplate.expire(key, 500L, TimeUnit.SECONDS);
    }

//    public void incrementPinCodeLimit(String key) {
//        hashOps.increment(key, 1L);
//    }

    public void removeKey(String key) {
        redisTemplate.delete(key);
    }

//    private static RedisTemplate<String, XxxEntity> pinCodeCredentialRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, XxxEntity> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
//        RedisSerializer<XxxEntity> userInformationRedisSerializer = new Jackson2JsonRedisSerializer<>(XxxEntity.class);
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(userInformationRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(userInformationRedisSerializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
}

