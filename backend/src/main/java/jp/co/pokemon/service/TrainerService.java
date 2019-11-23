package jp.co.pokemon.service;

import jp.co.pokemon.entity.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerService {

    Optional<List<Trainer>> findByUserId(int userId);

    Optional<Trainer> findByTrainerId(int trainerId);

    void create(long userId, String trainerName);

    boolean battleToggle(long userId, int trainerId);
}
