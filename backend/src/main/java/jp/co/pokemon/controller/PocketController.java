package jp.co.pokemon.controller;

import jp.co.pokemon.entity.User;
import jp.co.pokemon.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("pocket")
@AllArgsConstructor
@Slf4j
public class PocketController {

    private final UserService userService;

    @GetMapping("")
    public String pocketTest(Authentication authentication) {
        String name = authentication.getName();
        Optional<User> maybeUser = userService.findByName(name);
        log.info("UserInfo={}", maybeUser);
        log.info("LoggingIn!={}", name);
        return "こんにちは、" + name + "さん！::::" + maybeUser;
    }
}
