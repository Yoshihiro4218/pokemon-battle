package jp.co.pokemon.controller;

import jp.co.pokemon.entity.User;
import jp.co.pokemon.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String greeting(@AuthenticationPrincipal(expression = "user") User user) {
        return "hello admin " + user.getName();
    }

    @GetMapping(path = "{name}")
    public String greeting(@AuthenticationPrincipal(expression = "user") User user, @PathVariable(name = "name") String name) {
        return userService.findByName(name).map(u -> "hello " + u.getName()).orElse("unknown user");
    }

    @GetMapping(path = "echo/{message}")
    public String getEcho(@PathVariable(name = "message") String message) {
        return message.toUpperCase();
    }

    @PostMapping(path = "echo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String postEcho(@RequestBody Map<String, String> message) {
        return message.toString();
    }

}

