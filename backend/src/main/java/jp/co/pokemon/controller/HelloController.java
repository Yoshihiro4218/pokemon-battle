package jp.co.pokemon.controller;

import jp.co.pokemon.entity.User;
import jp.co.pokemon.repository.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.*;
import org.apache.commons.lang3.*;
import org.springframework.cache.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "hello")
@AllArgsConstructor
@Slf4j
public class HelloController {

    private final RedisRepository redisRepository;

    @GetMapping
    public String greeting() {
        return "hello world";
    }

//    @GetMapping
//    public String greeting(@AuthenticationPrincipal(expression = "user") User user, CsrfToken csrfToken) {
//        log.debug("token : {}", csrfToken.getToken());
//        log.debug("access user : {}", user.toString());
//        return "hello world";
//    }

    @GetMapping(path = "{message}")
    public String greeting(@PathVariable(name = "message") String message) {
        return "hello " + message;
    }

    @PostMapping
    public String postGreeting(@RequestParam(name = "message") String message) {
        return "hello " + message;
    }

    @GetMapping("/cache")
    public String cache() {
        String random = RandomStringUtils.random(5);
        redisRepository.save("TOKEN", "CATEGORY", random);
        return random;
    }

}