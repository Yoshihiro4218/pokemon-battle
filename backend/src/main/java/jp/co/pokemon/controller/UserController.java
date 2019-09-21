package jp.co.pokemon.controller;

import jp.co.pokemon.entity.User;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @GetMapping
    public String greeting(@AuthenticationPrincipal(expression = "user") User user) {
        return "hello " + user.getName();
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
