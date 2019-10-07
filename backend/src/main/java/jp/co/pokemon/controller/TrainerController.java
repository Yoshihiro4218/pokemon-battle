package jp.co.pokemon.controller;

import jp.co.pokemon.entity.Trainer;
import jp.co.pokemon.service.TrainerService;
import jp.co.pokemon.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trainers")
@AllArgsConstructor
@Slf4j
public class TrainerController {

    private final UserService userService;
    private final TrainerService trainerService;

    @GetMapping("")
    public List<Trainer> getMyTrainerList(Authentication authentication) {
        return userService.sessionUser(authentication)
                          .flatMap(u -> trainerService.findByUserId(u.getId().intValue())).get();
    }
}
