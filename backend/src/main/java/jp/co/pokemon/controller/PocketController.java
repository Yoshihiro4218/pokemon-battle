package jp.co.pokemon.controller;

import jp.co.pokemon.entity.Pocket;
import jp.co.pokemon.entity.Trainer;
import jp.co.pokemon.service.PocketService;
import jp.co.pokemon.service.TrainerService;
import jp.co.pokemon.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pockets")
@AllArgsConstructor
@Slf4j
public class PocketController {

    private final UserService userService;
    private final TrainerService trainerService;
    private final PocketService pocketService;

    @GetMapping("")
    public List<Pocket> getMyPocketPkList(Authentication authentication) {
        String name = authentication.getName();
        log.info("LoggingIn!={}", name);
        List<Trainer> trainerList = userService.findByName(name).flatMap(u -> trainerService.findByUserId(u.getId().intValue())).get();
        // TODO: そもそもJOINで取るべきです、ごめんなさい。。
        List<Pocket> pocketList = new ArrayList<>();
        for (Trainer trainer : trainerList) {
            pocketList.addAll(pocketService.findByTrainerId(trainer.getId()).get());
        }
        log.info("PocketList={}", pocketList);
        return pocketList;
    }
}
