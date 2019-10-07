package jp.co.pokemon.repository;

import jp.co.pokemon.entity.Trainer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrainerRepository {
    List<Trainer> findByUserId(int userId);
    Trainer findByTrainerId(int trainerId);
}
