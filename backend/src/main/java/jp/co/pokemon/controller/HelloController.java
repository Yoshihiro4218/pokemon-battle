package jp.co.pokemon.controller;

import jp.co.pokemon.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "hello")
@Slf4j
public class HelloController {

    @GetMapping
    public String greeting(@AuthenticationPrincipal(expression = "user") User user, CsrfToken csrfToken) {
        log.debug("token : {}", csrfToken.getToken());
        log.debug("access user : {}", user.toString());
        return "hello world";
    }

    @GetMapping(path = "{message}")
    public String greeting(@PathVariable(name = "message") String message) {
        return "hello " + message;
    }

    @PostMapping
    public String postGreeting(@RequestParam(name = "message") String message) {
        return "hello " + message;
    }

}