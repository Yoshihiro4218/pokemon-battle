package jp.co.pokemon.service.impl;

import jp.co.pokemon.controller.TrainerController;
import jp.co.pokemon.entity.Trainer;
import jp.co.pokemon.repository.TrainerRepository;
import jp.co.pokemon.service.TrainerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;

    @Override
    public Optional<List<Trainer>> findByUserId(int userId) {
        Optional<List<Trainer>> maybeTrainerList = Optional.ofNullable(trainerRepository.findByUserId(userId));
        log.info("TrainerList={}", maybeTrainerList);
        return maybeTrainerList;
    }

    @Override
    public Optional<Trainer> findByTrainerId(int trainerId) {
        return Optional.ofNullable(trainerRepository.findByTrainerId(trainerId));
    }

    @Override
    public void create(long userId, String trainerName) {
        trainerRepository.create(userId, trainerName);
    }

    @Override
    public boolean battleToggle(long userId, int trainerId) {
        if(trainerRepository.battleFlg(userId, trainerId)) {
            trainerRepository.battleToggle(false, trainerId);
            return false;
        } else {
            trainerRepository.battleToggle(true, trainerId);
            return true;
        }
    }
}
