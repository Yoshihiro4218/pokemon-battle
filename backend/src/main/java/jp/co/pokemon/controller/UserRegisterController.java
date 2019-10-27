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
public class UserRegisterController {
    private final UserService userService;

    @PostMapping("/new")
    public String newUser(@ModelAttribute UserRegisterForm userRegisterForm) {
        log.info("NewUser={}", userRegisterForm);
        return userService.create(userRegisterForm.getName(), userRegisterForm.getPassword(), userRegisterForm.getEmail());
    }

    @Data
    public static class UserRegisterForm {
        private String name;
        private String password;
        private String email;
    }
}
