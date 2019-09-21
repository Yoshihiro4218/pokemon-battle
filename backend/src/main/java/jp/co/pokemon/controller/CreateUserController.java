package jp.co.pokemon.controller;

import jp.co.pokemon.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class CreateUserController {
    private final UserService userService;

    @PostMapping("/new")
    public String newUser(@ModelAttribute NewUser newUser) {
        log.info("NewUser={}", newUser);
        return userService.create(newUser.getName(), newUser.getPassword(), newUser.getEmail());
    }

    @Data
    public static class NewUser {
        private String name;
        private String password;
        private String email;
    }
}
