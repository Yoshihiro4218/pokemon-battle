package jp.co.pokemon.service;

import jp.co.pokemon.entity.Pocket;

import java.util.List;
import java.util.Optional;

public interface PocketService {

    Optional<List<Pocket>> findByTrainerId(int trainerId);
}
