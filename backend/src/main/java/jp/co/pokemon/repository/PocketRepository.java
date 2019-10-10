package jp.co.pokemon.repository;

import jp.co.pokemon.entity.Pocket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PocketRepository {
    // TODO: ORDER BY POSITION しないといけなかった
    List<Pocket> findByTrainerId(int trainerId);
    List<Pocket> findByTrainerIdOrderByPosition(int trainerId);
    Pocket findOnePocketByTrainerId(int trainerId);
}
