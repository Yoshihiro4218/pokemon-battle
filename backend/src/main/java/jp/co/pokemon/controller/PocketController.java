package jp.co.pokemon.controller;

import jp.co.pokemon.entity.Pocket;
import jp.co.pokemon.entity.Trainer;
import jp.co.pokemon.service.PocketService;
import jp.co.pokemon.service.TrainerService;
import jp.co.pokemon.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public List<Pocket> getMyAllPocketPkList(Authentication authentication) {
        List<Trainer> trainerList = userService.sessionUser(authentication)
                                               .flatMap(u -> trainerService.findByUserId(u.getId().intValue())).get();
        // TODO: そもそもJOINで取るべきです、ごめんなさい。。
        List<Pocket> pocketList = new ArrayList<>();
        for (Trainer trainer : trainerList) {
            pocketList.addAll(pocketService.findByTrainerIdOrderByPosition(trainer.getId()).get());
        }
        log.info("PocketList={}", pocketList);
        return pocketList;
    }

    @GetMapping("/{trainerId}")
    public List<Pocket> getMyPocketPkList(@PathVariable("trainerId") int trainerId, Authentication authentication) {
        return userService.sessionUser(authentication)
                          .flatMap(u -> trainerService.findByUserId(u.getId().intValue()))
                          .orElseThrow(() -> new RuntimeException("No Trainer..."))
                          .stream()
                          .filter(t -> t.getId() == trainerId)
                          .findFirst()
                          .flatMap(t -> pocketService.findByTrainerIdOrderByPosition(t.getId()))
                          .orElseThrow(() -> new RuntimeException("No Pokemon..."));
    }

    @PostMapping("/{trainerId}")
    public void postNewPkList(@PathVariable("trainerId") int trainerId,
                              @RequestParam("pkList") List<Integer> pkList,
                              Authentication authentication) {
        log.info("NewPokes={}", pkList);
        userService.sessionUser(authentication)
                   .flatMap(u -> trainerService.findByUserId(u.getId().intValue()))
                   .orElseThrow(() -> new RuntimeException("No Trainer..."));
        pocketService.updateMyPokes(trainerId, pkList);
    }
}
