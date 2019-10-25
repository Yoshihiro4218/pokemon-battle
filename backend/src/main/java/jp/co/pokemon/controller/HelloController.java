package jp.co.pokemon.controller;

import jp.co.pokemon.entity.*;
import jp.co.pokemon.props.*;
import jp.co.pokemon.repository.*;
import jp.co.pokemon.service.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.*;
import org.apache.commons.lang3.*;
import org.springframework.cache.annotation.*;
import org.springframework.mail.*;
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
    private final MailService mailService;

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
        int i = (int)(Math.random()*10);
        String uuid = UUID.randomUUID().toString();
        redisRepository.save("TOKEN", "CATEGORY-" + i, uuid);
        return "CATEGORY:" + i + "::VALUE=" + uuid;
    }

    @GetMapping("/cache/{category}")
    public String cacheGet(@PathVariable("category")int i) {
        return redisRepository.find("TOKEN", i);
    }

    @GetMapping("/mail")
    public String sendMail() {
        String subject = "SUBJECT";
        String addressTo = "y.kadono4218@gmail.com";
        String body = "MAIL_BODY";

        mailService.send(subject, addressTo, body);
        return "SEND!!";
    }
}